package com.platform.mappl.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.platform.mappl.model.UserPreference;
import com.platform.mappl.service.UserPreferenceService;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/api/user-preferences")
public class UserPreferenceController {

    private static final Logger logger = LoggerFactory.getLogger(UserPreferenceController.class);

    @Autowired
    private UserPreferenceService userPreferenceService;

    @GetMapping
    public List<UserPreference> getAllUserPreferences() {
        return userPreferenceService.getAllUserPreferences();
    }

    @GetMapping("/{id}")
    public Optional<UserPreference> getUserPreferenceById(@PathVariable int id) {
        return userPreferenceService.getUserPreferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserPreference createUserPreference(@RequestBody @Valid UserPreference userPreference, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errors.append(error.getDefaultMessage()).append(" ");
            }
            throw new ValidationException(errors.toString());
        }
        return userPreferenceService.saveUserPreference(userPreference);
    }

    @PutMapping("/{id}")
    public UserPreference updateUserPreference(@PathVariable int id, @RequestBody @Valid UserPreference userPreference) {
        userPreference.setId(id);
        return userPreferenceService.saveUserPreference(userPreference);
    }

    @DeleteMapping("/{id}")
    public void deleteUserPreference(@PathVariable int id) {
        userPreferenceService.deleteUserPreference(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserPreference> getUserPreferenceByUserId(@PathVariable int userId) {
        return userPreferenceService.getUserPreferenceByUserId(userId);
    }
}
