/*
package com.skh;

import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/anthropic")
public class AnthropicController {

    private final AnthropicChatModel anthropicChatModel;

    public AnthropicController(AnthropicChatModel anthropicChatModel) {
        this.anthropicChatModel = anthropicChatModel;
    }

    @GetMapping(value = "/{message}", produces = "text/event-stream")
    public Flux<String> fetchAnswer(@PathVariable String message) {
        // Use .stream() instead of .call() to remain non-blocking
        return anthropicChatModel.stream(new Prompt(message))
                .map(response -> {
                    if (response.getResult() != null && response.getResult().getOutput() != null) {
                        return response.getResult().getOutput().getText();
                    }
                    return "";
                });
    }
}
*/
