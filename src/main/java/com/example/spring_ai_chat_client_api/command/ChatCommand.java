package com.example.spring_ai_chat_client_api.command;

import com.example.spring_ai_chat_client_api.model.ActorFilms;
import com.example.spring_ai_chat_client_api.service.ChatService;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Command
public class ChatCommand {

    private final ChatService chatService;

    public ChatCommand(ChatService chatService) {
        this.chatService = chatService;
    }

    @Command(command = "q")
    public String chat(@Option(defaultValue = "tell me a joke") String message) {
        return chatService.chat(message);
    }

    @Command(command = "cwr")//cwr: chat with response
    public String chatWithResponse(@Option(defaultValue = "tell me a joke") String message) {
        return chatService.chatWithResponse(message);
    }

    @Command(command = "af")//af: actor-films
    public ActorFilms chatWithEntity(@Option(defaultValue = "Tom Hanks") String actor) {
        return chatService.chatWithEntity(actor);
    }

    @Command(command = "afs")//afs: actors films
    @GetMapping("/ai/chat/actors-films")
    public List<ActorFilms> chatWithEntities(@Option(defaultValue = "Sylvester Stallone,Brad Pitt") List<String> actors) {
        return chatService.chatWithEntity(actors);
    }
}
