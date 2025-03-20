package com.example.spring_ai_chat_client_api.service;

import com.example.spring_ai_chat_client_api.tool.DateTimeTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatWithToolService {

    private final ChatClient chatClient;

    public ChatWithToolService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String chat(String message) {
        return chatClient.prompt()
                .user(message)
                .tools(new DateTimeTools())
                .call()
                .content();
    }
}
