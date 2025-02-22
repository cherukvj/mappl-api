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

import com.platform.mappl.model.UserConnection;
import com.platform.mappl.service.UserConnectionService;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/api/user-connections")
public class UserConnectionController {

    private static final Logger logger = LoggerFactory.getLogger(UserConnectionController.class);

    @Autowired
    private UserConnectionService userConnectionService;

    @GetMapping
    public List<UserConnection> getAllUserConnections() {
        return userConnectionService.getAllUserConnections();
    }

    @GetMapping("/{id}")
    public Optional<UserConnection> getUserConnectionById(@PathVariable int id) {
        return userConnectionService.getUserConnectionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserConnection createUserConnection(@RequestBody @Valid UserConnection userConnection, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errors.append(error.getDefaultMessage()).append(" ");
            }
            throw new ValidationException(errors.toString());
        }
        return userConnectionService.saveUserConnection(userConnection);
    }

    @PutMapping("/{id}")
    public UserConnection updateUserConnection(@PathVariable int id, @RequestBody @Valid UserConnection userConnection) {
        userConnection.setId(id);
        return userConnectionService.saveUserConnection(userConnection);
    }

    @DeleteMapping("/{id}")
    public void deleteUserConnection(@PathVariable int id) {
        userConnectionService.deleteUserConnection(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserConnection> getUserConnectionByUserId(@PathVariable int userId) {
        return userConnectionService.getUserConnectionByUserId(userId);
    }
}
