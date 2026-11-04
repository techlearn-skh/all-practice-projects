package com.skh;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ollama")
public class OllamaController {
/*
Call using:
http://localhost:9000/ollama/what is USA capital city?
 */

    private final OllamaChatModel ollamaChatModel;
    public OllamaController(OllamaChatModel ollamaChatModel){
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
