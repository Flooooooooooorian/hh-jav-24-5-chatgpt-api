package de.neuefische.java.hhjav245chatgptapi.chatgpt.service;

import de.neuefische.java.hhjav245chatgptapi.chatgpt.dto.ChatGptMessage;
import de.neuefische.java.hhjav245chatgptapi.chatgpt.dto.ChatGptRequest;
import de.neuefische.java.hhjav245chatgptapi.chatgpt.dto.ChatGptResponse;
import de.neuefische.java.hhjav245chatgptapi.chatgpt.dto.ChatGptResponseFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ChatGptApiService {

    private RestClient restClient;

    @Value("${app.chatgpt.api.key}")
    private String apiKey;

    public ChatGptApiService(RestClient.Builder builder) {
        restClient = builder.build();
    }

    public String getChatGptResponse(String message) {
        ChatGptResponse response = restClient.post()
                .uri("https://api.openai.com/v1/chat/completions")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ChatGptRequest("gpt-4o-mini",
                        List.of(new ChatGptMessage("user", message)),
                        new ChatGptResponseFormat("json_object")))
                .retrieve()
                .body(ChatGptResponse.class);

        System.out.println(response);
        return response.choices().get(0).message().content();
    }
}
