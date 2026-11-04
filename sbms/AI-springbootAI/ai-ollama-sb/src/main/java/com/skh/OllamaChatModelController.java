package com.skh;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ollama/chatModel")
public class OllamaChatModelController {

/*
http://localhost:9000/ollama/chatModel/what is france capital city?
 */
    private final OllamaChatModel ollamaChatModel;
    public OllamaChatModelController(OllamaChatModel ollamaChatModel){
        this.ollamaChatModel = ollamaChatModel;
    }

    @GetMapping("/{message}")
    public Flux<String> fetchAnswer(@PathVariable String message) {
        // Use .stream() instead of .call() to remain non-blocking
        return ollamaChatModel.stream(new Prompt(message))
                .map(response -> response.getResult().getOutput().getText());
    }

    /*@GetMapping("/{message}")
    public Flux<String> fetchAnswer(@PathVariable String message) {

        Prompt prompt = new Prompt(
                message,
                OllamaChatOptions.builder()
                        .model("deepseek-r1:latest")
                        .temperature(0.7)
                        .build()
        );

        return ollamaChatModel.stream(prompt)
                .map(response ->
                        response.getResult().getOutput().getText());
    }*/
}
