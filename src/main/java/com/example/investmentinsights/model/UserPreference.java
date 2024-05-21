package com.example.investmentinsights.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "userPreferences")
public class UserPreference {
    @Id
    private String id;
    private String userId;
    private String preferences;
}
