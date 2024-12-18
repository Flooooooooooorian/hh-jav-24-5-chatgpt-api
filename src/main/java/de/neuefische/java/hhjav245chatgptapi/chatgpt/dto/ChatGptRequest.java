package de.neuefische.java.hhjav245chatgptapi.chatgpt.dto;

import java.util.List;

public record ChatGptRequest(
        String model,
        List<ChatGptMessage> messages,
        ChatGptResponseFormat response_format
) {
}
