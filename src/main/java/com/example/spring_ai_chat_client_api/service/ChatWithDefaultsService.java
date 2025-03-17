package com.example.spring_ai_chat_client_api.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatWithDefaultsService {

    private final ChatClient chatClient;

    public ChatWithDefaultsService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.defaultSystem("You are a friendly chat bot that answers question in the voice of a Pirate")
                .build();
    }

    public String chat(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
