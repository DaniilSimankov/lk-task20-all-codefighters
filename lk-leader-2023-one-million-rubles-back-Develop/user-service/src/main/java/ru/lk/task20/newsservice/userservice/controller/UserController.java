package ru.lk.task20.newsservice.userservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lk.task20.newsservice.userservice.dto.FriendshipModelResponse;
import ru.lk.task20.newsservice.userservice.dto.ScoreboardResponse;
import ru.lk.task20.newsservice.userservice.dto.UpdateStatsResponse;
import ru.lk.task20.newsservice.userservice.dto.UserStatsRequest;
import ru.lk.task20.newsservice.userservice.model.User;
import ru.lk.task20.newsservice.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/update-stats")
    @ResponseStatus(HttpStatus.OK)
    public UpdateStatsResponse updateStats(@RequestHeader("Authorization") String token, @RequestBody UserStatsRequest userStatsRequest) {
        UpdateStatsResponse response = userService.updateStats(userStatsRequest, token);
        return response;
    }

    @PostMapping("/add-completed-test-id")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompletedTestIdToUser(@RequestHeader("Authorization") String token) {
        userService.getAllCompletedTests(token);
        ResponseEntity.ok("Completed test ID added to user successfully.");
    }

    @GetMapping("/friendship-requests")
    @ResponseStatus(HttpStatus.OK)
    public List<FriendshipModelResponse> getAllFriendshipRequests(@RequestHeader("Authorization") String token) {
        return userService.getAllActualFriendshipRequests(token);
    }

    @PostMapping("/send-friendship-request")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendFriendshipRequest(@RequestHeader("Authorization") String token, @RequestParam("id") String id) {
        userService.sendFriendshipRequest(token, id);
    }

    @PostMapping("/handle-friendship-request")
    public ResponseEntity<String> handleFriendshipRequest(@RequestParam("id") String id, @RequestParam("isAccepted") boolean isAccepted) {
        userService.handleFriendshipRequest(isAccepted, id);
        return ResponseEntity.ok("Friendship request handled successfully.");
    }

    @PostMapping("/add-new-bought-video-course")
    public void addNewBoughtVideoCourse(@RequestHeader("Authorization") String token, @RequestParam("id") String id) {
        userService.addNewBoughtVideoCourse(token, id);
    }

    @GetMapping("/users-by-xp")
    @ResponseStatus(HttpStatus.OK)
    public List<ScoreboardResponse> getAllUsersByXpDesc() {
        List<ScoreboardResponse> usersByXpDesc = userService.getAllUsersByXpDesc();
        return usersByXpDesc;
    }


}
