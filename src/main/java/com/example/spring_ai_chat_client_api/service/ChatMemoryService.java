package com.example.spring_ai_chat_client_api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatMemoryService {

    private static final Logger logger = LoggerFactory.getLogger(ChatMemoryService.class);

    private final ChatClient chatClientWithoutMemory;
    private final ChatClient chatClientWithMemory;

    public ChatMemoryService(ChatClient.Builder chatClientBuilder, ChatClient.Builder builder) {
        this.chatClientWithMemory = chatClientBuilder
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
        this.chatClientWithoutMemory = builder.build();
    }

    public void chat() {
        chatWithoutMemory();
        chatWithMemory();
    }

    private void chatWithoutMemory() {
        String firstResponse = chatClientWithoutMemory.prompt()
                .user("My name is Jack")
                .call()
                .content();
        logger.info("without memory first response: {}", firstResponse);

        String secondResponse = chatClientWithoutMemory.prompt()
                .user("What is my name ?")
                .call()
                .content();
        logger.info("without memory second response: {}", secondResponse);
    }

    private void chatWithMemory() {
        String firstResponse = chatClientWithMemory.prompt()
                .user("My name is Jack")
                .call()
                .content();
        logger.info("with memory first response: {}", firstResponse);

        String secondResponse = chatClientWithMemory.prompt()
                .user("What is my name ?")
                .call()
                .content();
        logger.info("with memory second response: {}", secondResponse);
    }
}
