/*
package com.skh;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/openai")
public class OpenAIController {

    private final OpenAiChatModel openAiChatModel;

    public OpenAIController(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    @GetMapping(value = "/{message}", produces = "text/event-stream")
    public Flux<String> fetchAnswer(@PathVariable String message) {
        // Use .stream() instead of .call() to remain non-blocking
        return openAiChatModel.stream(new Prompt(message))
                .map(response -> {
                    if (response.getResult() != null && response.getResult().getOutput() != null) {
                        return response.getResult().getOutput().getText();
                    }
                    return "";
                });
    }
}
*/
