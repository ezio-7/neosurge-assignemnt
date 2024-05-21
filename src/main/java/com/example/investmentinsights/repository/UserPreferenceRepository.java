package com.example.investmentinsights.repository;

import com.example.investmentinsights.model.UserPreference;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserPreferenceRepository extends MongoRepository<UserPreference, String> {
}
