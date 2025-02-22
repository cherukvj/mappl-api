package com.platform.mappl.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.mappl.model.UserPreference;
import com.platform.mappl.repository.UserPreferenceRepository;

@Service
public class UserPreferenceService {

    private static final Logger logger = LoggerFactory.getLogger(UserPreferenceService.class);

    @Autowired
    private UserPreferenceRepository userPreferenceRepository;

    public List<UserPreference> getAllUserPreferences() {
        logger.info("Fetching all user preferences");
        return userPreferenceRepository.findAll();
    }

    public Optional<UserPreference> getUserPreferenceById(int id) {
        logger.info("Fetching user preference with ID {}", id);
        return userPreferenceRepository.findById(id);
    }

    public UserPreference saveUserPreference(UserPreference userPreference) {
        logger.info("Saving user preference: {}", userPreference);
        return userPreferenceRepository.save(userPreference);
    }

    public void deleteUserPreference(int id) {
        logger.info("Deleting user preference with ID {}", id);
        userPreferenceRepository.deleteById(id);
    }

    public List<UserPreference> getUserPreferenceByUserId(int userId) {
        logger.info("Fetching user preferences with User ID {}", userId);
        return userPreferenceRepository.findByAppUserId(userId);
    }
}
