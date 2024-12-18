package de.neuefische.java.hhjav245chatgptapi.chatgpt.dto;

import java.util.List;

public record ChatGptResponse(
        List<ChatGptChoice> choices
) {
}
