package com.example.spring_ai_chat_client_api.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.api.AdvisedRequest;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class ChatWithAdvisorService {

    private final ChatClient chatClient;

    public ChatWithAdvisorService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(new SimpleLoggerAdvisor(
                        (AdvisedRequest request) -> "Custom request: " + request.userText(),
                        (ChatResponse response) -> "Custom response: " + response.getResult(),
                        0
                ))
                .build();
    }

    public String chat(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
