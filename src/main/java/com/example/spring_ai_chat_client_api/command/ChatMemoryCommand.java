package com.example.spring_ai_chat_client_api.command;

import com.example.spring_ai_chat_client_api.service.ChatMemoryService;
import org.springframework.shell.command.annotation.Command;

@Command
public class ChatMemoryCommand {

    private final ChatMemoryService chatMemoryService;

    public ChatMemoryCommand(ChatMemoryService chatMemoryService) {
        this.chatMemoryService = chatMemoryService;
    }

    @Command(command = "m")//m: memory
    public void chat() {
        chatMemoryService.chat();
    }
}
