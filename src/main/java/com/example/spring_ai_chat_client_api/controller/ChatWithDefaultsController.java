package com.example.spring_ai_chat_client_api.controller;

import com.example.spring_ai_chat_client_api.service.ChatWithDefaultsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatWithDefaultsController {

    private final ChatWithDefaultsService chatWithDefaultsService;

    public ChatWithDefaultsController(ChatWithDefaultsService chatWithDefaultsService) {
        this.chatWithDefaultsService = chatWithDefaultsService;
    }

    @GetMapping("/ai/chat/with-defaults")
    public String chatWithDefaults(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return chatWithDefaultsService.chat(message);
    }
}
