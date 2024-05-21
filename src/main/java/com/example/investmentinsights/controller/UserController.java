package com.example.investmentinsights.controller;

import com.example.investmentinsights.model.UserPreference;
import com.example.investmentinsights.repository.UserPreferenceRepository;
import com.example.investmentinsights.service.Gpt4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserPreferenceRepository userPreferenceRepository;

    @Autowired
    private Gpt4Service gpt4Service;

    @PostMapping("/preferences")
    public UserPreference saveUserPreferences(@RequestBody UserPreference userPreference) {
        return userPreferenceRepository.save(userPreference);
    }

    @GetMapping("/insights")
    public String getInvestmentInsights(@RequestParam String userId) {
        UserPreference userPreference = userPreferenceRepository.findById(userId).orElse(null);
        if (userPreference != null) {
            return gpt4Service.generateInvestmentInsight(userPreference.getPreferences());
        } else {
            return "User preferences not found!";
        }
    }
}
