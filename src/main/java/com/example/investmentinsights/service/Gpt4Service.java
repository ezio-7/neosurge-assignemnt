package com.example.investmentinsights.service;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Gpt4Service {

    private final OpenAiService openAiService;

    public Gpt4Service(@Value("${openai.api.key}") String apiKey) {
        this.openAiService = new OpenAiService(apiKey);
    }

    public String generateInvestmentInsight(String userInput) {
        CompletionRequest request = CompletionRequest.builder()
                .prompt(userInput)
                .maxTokens(200)
                .build();

        CompletionResult result = openAiService.createCompletion(request);
        return result.getChoices().get(0).getText();
    }
}
