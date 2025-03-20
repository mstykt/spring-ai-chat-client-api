package com.example.spring_ai_chat_client_api.command;

import com.example.spring_ai_chat_client_api.service.ChatWithToolService;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

@Command
public class ChatWithToolCommand {

    private final ChatWithToolService service;

    public ChatWithToolCommand(ChatWithToolService service) {
        this.service = service;
    }

    @Command(command = "t")
    public String chat(@Option(defaultValue = "what this the time and date") String message) {
        return service.chat(message);
    }
}
