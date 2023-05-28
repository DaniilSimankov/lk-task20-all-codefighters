package ru.lk.task20.authserver.service;

import com.google.gson.Gson;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import com.vk.api.sdk.objects.users.responses.GetResponse;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VKAuthService {
    private final VkApiClient vk;
    private final int APP_ID = 51659317;
    private final String CLIENT_SECRET = "************";
    private final String REDIRECT_URI = "https://oauth.vk.com/blank.html";


    public UserActor authenticate(String code) throws Exception {
        UserAuthResponse authResponse = vk.oAuth()
                .userAuthorizationCodeFlow(APP_ID, CLIENT_SECRET, REDIRECT_URI, code)
                .execute();

        UserActor userActor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());

        List<GetResponse> vkUsers = vk.users()
                .get(userActor)
                .userIds(String.valueOf(userActor.getId()))
                .execute();

        GetResponse vkUser = vkUsers.get(0);

        //TODO

        return new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
    }
}
