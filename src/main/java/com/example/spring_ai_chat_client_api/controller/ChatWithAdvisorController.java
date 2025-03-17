package com.example.spring_ai_chat_client_api.controller;

import com.example.spring_ai_chat_client_api.service.ChatWithAdvisorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatWithAdvisorController {

    private final ChatWithAdvisorService service;

    public ChatWithAdvisorController(ChatWithAdvisorService service) {
        this.service = service;
    }

    @GetMapping("/ai/chat/advisor")
    public String chat(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return service.chat(message);
    }
}
