package de.neuefische.java.hhjav245chatgptapi.chatgpt.controller;

import de.neuefische.java.hhjav245chatgptapi.chatgpt.service.ChatGptApiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat-gpt")
public class ChatGptController {

    private final ChatGptApiService chatGptApiService;

    public ChatGptController(ChatGptApiService chatGptApiService) {
        this.chatGptApiService = chatGptApiService;
    }

    @PostMapping
    public String getChatGptResponse(@RequestBody String message) {
        return chatGptApiService.getChatGptResponse(message);
    }
}
