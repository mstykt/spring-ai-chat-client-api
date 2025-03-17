package com.example.spring_ai_chat_client_api.command;

import com.example.spring_ai_chat_client_api.service.ChatWithAdvisorService;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

@Command
public class ChatWithAdvisorCommand {

    private final ChatWithAdvisorService service;

    public ChatWithAdvisorCommand(ChatWithAdvisorService service) {
        this.service = service;
    }

    @Command(command = "a")//a: advisor
    public String chat(@Option(defaultValue = "Tell me a joke") String message) {
        return service.chat(message);
    }
}
