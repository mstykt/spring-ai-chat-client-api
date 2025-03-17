package com.example.spring_ai_chat_client_api.service;

import com.example.spring_ai_chat_client_api.model.ActorFilms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private static final Logger logger = LoggerFactory.getLogger(ChatService.class);

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String chat(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    public String chatWithResponse(String message) {
        ChatResponse response = chatClient.prompt()
                .user(message)
                .call()
                .chatResponse();

        String text = response.getResult().getOutput().getText();
        logger.info(text);
        logger.info(response.getMetadata().getId());
        logger.info(response.getMetadata().getModel());
        logger.info(String.valueOf(response.getMetadata().getPromptMetadata().iterator().hasNext()));
        logger.info(response.getMetadata().getUsage().getTotalTokens().toString());
        logger.info(response.getMetadata().getUsage().getPromptTokens().toString());
        logger.info(response.getMetadata().getUsage().getCompletionTokens().toString());
        logger.info(response.getMetadata().getUsage().toString());
        logger.info(response.getMetadata().getRateLimit().getTokensLimit().toString());

        return text;
    }

    public ActorFilms chatWithEntity(String actor) {
        ActorFilms actorFilms = chatClient.prompt()
                .user("Generate the filmography for " + actor)
                .call()
                .entity(ActorFilms.class);
        logger.info(actorFilms.toString());

        return actorFilms;
    }

    public List<ActorFilms> chatWithEntity(List<String> actorList) {
        String actors = String.join(" and ", actorList);
        List<ActorFilms> actorFilms = chatClient.prompt()
                .user("Generate the filmography of 5 movies for " + actors)
                .call()
                .entity(new ParameterizedTypeReference<>() {
                });
        logger.info(actorFilms.toString());

        return actorFilms;
    }
}
