package ru.lk.task20.newsservice.userservice.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lk.task20.newsservice.userservice.dto.FriendshipModelResponse;
import ru.lk.task20.newsservice.userservice.dto.ScoreboardResponse;
import ru.lk.task20.newsservice.userservice.dto.UpdateStatsResponse;
import ru.lk.task20.newsservice.userservice.dto.UserStatsRequest;
import ru.lk.task20.newsservice.userservice.model.Friendship;
import ru.lk.task20.newsservice.userservice.model.Status;
import ru.lk.task20.newsservice.userservice.model.User;
import ru.lk.task20.newsservice.userservice.repository.FriendshipRepository;
import ru.lk.task20.newsservice.userservice.repository.UserRepository;
import ru.lk.task20.newsservice.userservice.util.JwtUtil;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final FriendshipRepository friendshipRepository;

    @Transactional
    public UpdateStatsResponse updateStats(@NonNull UserStatsRequest userStatsRequest, @NonNull String token) {
        User user = getUserByToken(token);

        UpdateStatsResponse.UpdateStatsResponseBuilder updateStatsResponse = UpdateStatsResponse.builder();
        if (userStatsRequest.getXp() != 0) {
            if (userStatsRequest.getXp() >= user.getXpForNextLvl()) {
                user.setLvl(user.getLvl() + 1);
                user.setXpForNextLvl(user.getLvl() * 5 - 7 % user.getXpForNextLvl());

                updateStatsResponse.isNewLvl(true);
            } else {
                user.setXpForNextLvl(user.getXpForNextLvl() - userStatsRequest.getXp());
                updateStatsResponse.isNewLvl(false);
            }
            user.setXp(user.getXp() + userStatsRequest.getXp());

        }
        user.setCoins(user.getCoins() + userStatsRequest.getCoins());

        userRepository.save(user);
        return updateStatsResponse.build();
    }

    @Transactional
    public void getAllCompletedTests(@NonNull String token) {
        User user = getUserByToken(token);


        // TODO INTERCOMMUNICATION
    }

    @Transactional
    public List<FriendshipModelResponse> getAllActualFriendshipRequests(@NonNull String token) {
        String userId = JwtUtil.getUserIdFromToken(token);
        if (Objects.isNull(userId)) {
            throw new RuntimeException("Invalid token");
        }

        List<Friendship> friendshipList = friendshipRepository.getFriendshipsByIdTo(userId);
        return friendshipList.stream().map(this::mapToFriendshipModelResponse).toList();
    }

    @Transactional
    public void sendFriendshipRequest(@NonNull String token, @NonNull String id) {
        String userId = JwtUtil.getUserIdFromToken(token);
        if (Objects.isNull(userId)) {
            throw new RuntimeException("Invalid token");
        }
        User userTo = userRepository.findUserById(id);
        if (Objects.isNull(userTo)) {
            throw new RuntimeException("User not found");
        }
        Friendship friendship = Friendship.builder()
                .idFrom(userId)
                .idTo(userTo.getId())
                .status(Status.WAITING)
                .build();
        friendshipRepository.save(friendship);
    }

    @Transactional
    public void handleFriendshipRequest(@NonNull boolean isAccepted, @NonNull String id) {
        Friendship friendship = friendshipRepository.findFriendshipById(id);

        if (Objects.isNull(friendship)) {
            new RuntimeException("Friendship not found");
        }

        if (friendship.getStatus() == Status.WAITING) {
            if (isAccepted) {
                friendship.setStatus(Status.ACCEPTED);
                String userIdFrom = friendship.getIdFrom();
                String userIdTo = friendship.getIdTo();

                User userFrom = userRepository.findById(userIdFrom).orElseThrow(() -> new RuntimeException("User not found"));
                User userTo = userRepository.findById(userIdTo).orElseThrow(() -> new RuntimeException("User not found"));

                userFrom.getFriendsIds().add(userIdTo);
                userTo.getFriendsIds().add(userIdFrom);

                userRepository.save(userFrom);
                userRepository.save(userTo);
            } else {
                friendship.setStatus(Status.REJECTED);
            }

            friendshipRepository.save(friendship);
        }
    }


    @Transactional
    public void addNewBoughtVideoCourse(@NonNull String token, @NonNull String id) {
        User user = getUserByToken(token);

        user.getBoughtCoursesIds().add(id);
        userRepository.save(user);
    }

    public List<ScoreboardResponse> getAllUsersByXpDesc() {
        List<User> userList = userRepository.findAllByOrderByXpDesc();
        return userList.stream().map(this::mapToScoreboardResponse).toList();
    }

    // HELP METHODS

    public FriendshipModelResponse mapToFriendshipModelResponse(Friendship friendship) {
        User user = userRepository.findUserById(friendship.getIdFrom());
        return FriendshipModelResponse.builder()
                .nameFrom(user.getFirstName() + " " + user.getSecondName())
                .fromPhotoUrl(user.getPhotoUrl())
                .build();
    }

    public ScoreboardResponse mapToScoreboardResponse(User user) {
        return ScoreboardResponse.builder()
                .name(user.getFirstName() + " " + user.getSecondName())
                .photoUrl(user.getPhotoUrl())
                .xp(user.getXp())
                .build();
    }

    private User getUserByToken(String token) {
        String userId = JwtUtil.getUserIdFromToken(token);
        if (Objects.isNull(userId)) {
            throw new RuntimeException("Invalid token");
        }
        User user = userRepository.findUserById(userId);
        if (Objects.isNull(user)) {
            throw new RuntimeException("User not found");
        }
        return user;
    }
}
