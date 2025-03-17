package com.example.spring_ai_chat_client_api.controller;

import com.example.spring_ai_chat_client_api.service.ChatMemoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatMemoryController {

    private final ChatMemoryService chatMemoryService;

    public ChatMemoryController(ChatMemoryService chatMemoryService) {
        this.chatMemoryService = chatMemoryService;
    }

    @GetMapping("/ai/chat/memory")
    public void chat() {
        chatMemoryService.chat();
    }
}
