
package com.skh;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ollama/chatClient")
public class OllamaChatClientController {

    /*
    http://localhost:9000/ollama/chatClient/what is france capital city?
     */
    private final ChatClient chatClient;

    public OllamaChatClientController(
            OllamaChatModel ollamaChatModel) {

        this.chatClient = ChatClient.create(ollamaChatModel);
    }

    @GetMapping("/{message}")
    public Flux<String> fetchAnswer(
            @PathVariable String message) {

        return chatClient.prompt()
                .user(message)
                .stream()
                .content();
    }
}
