package com.example.spring_ai_chat_client_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@CommandScan
@SpringBootApplication
public class SpringAiChatClientApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiChatClientApiApplication.class, args);
    }

}
