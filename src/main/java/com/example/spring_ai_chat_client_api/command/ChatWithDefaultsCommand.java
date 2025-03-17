package com.example.spring_ai_chat_client_api.command;

import com.example.spring_ai_chat_client_api.service.ChatWithDefaultsService;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

@Command
public class ChatWithDefaultsCommand {

    private final ChatWithDefaultsService chatWithDefaultsService;

    public ChatWithDefaultsCommand(ChatWithDefaultsService chatWithDefaultsService) {
        this.chatWithDefaultsService = chatWithDefaultsService;
    }

    @Command(command = "wd")//wd: with defaults
    public String chatWithDefaults(@Option(defaultValue = "Tell me a joke") String message) {
        return chatWithDefaultsService.chat(message);
    }
}
