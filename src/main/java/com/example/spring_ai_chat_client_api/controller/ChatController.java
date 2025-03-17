package com.example.spring_ai_chat_client_api.controller;


import com.example.spring_ai_chat_client_api.model.ActorFilms;
import com.example.spring_ai_chat_client_api.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/ai/chat")
    public String chat(@RequestParam(value = "message", defaultValue = "tell me a joke") String message) {
        return chatService.chat(message);
    }

    @GetMapping("/ai/chat-with-response")
    public String chatWithResponse(@RequestParam(value = "message", defaultValue = "tell me a joke") String message) {
        return chatService.chatWithResponse(message);
    }


    @GetMapping("/ai/chat/actor-films")
    public ActorFilms chatWithEntity(@RequestParam(value = "actor") String actor) {
        return chatService.chatWithEntity(actor);
    }

    @GetMapping("/ai/chat/actors-films")
    public List<ActorFilms> chatWithEntities(@RequestParam(value = "actors") List<String> actors) {
        return chatService.chatWithEntity(actors);
    }
}
