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

import com.platform.mappl.model.UserInvite;
import com.platform.mappl.service.UserInviteService;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/api/user-invites")
public class UserInviteController {

    private static final Logger logger = LoggerFactory.getLogger(UserInviteController.class);

    @Autowired
    private UserInviteService userInviteService;

    @GetMapping
    public List<UserInvite> getAllUserInvites() {
        return userInviteService.getAllUserInvites();
    }

    @GetMapping("/{id}")
    public Optional<UserInvite> getUserInviteById(@PathVariable int id) {
        return userInviteService.getUserInviteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserInvite createUserInvite(@RequestBody @Valid UserInvite userInvite, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errors.append(error.getDefaultMessage()).append(" ");
            }
            throw new ValidationException(errors.toString());
        }
        return userInviteService.saveUserInvite(userInvite);
    }

    @PutMapping("/{id}")
    public UserInvite updateUserInvite(@PathVariable int id, @RequestBody @Valid UserInvite userInvite) {
        userInvite.setId(id);
        return userInviteService.saveUserInvite(userInvite);
    }

    @DeleteMapping("/{id}")
    public void deleteUserInvite(@PathVariable int id) {
        userInviteService.deleteUserInvite(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserInvite> getUserInviteByUserId(@PathVariable int userId) {
        return userInviteService.getUserInviteByUserId(userId);
    }
    
    @GetMapping("/user/{userId}/invite/{inviteUserId}")
    public UserInvite getUserInviteByUserId(@PathVariable int userId, @PathVariable int inviteUserId) {
        return userInviteService.getUserInviteByUserIdAndInviteUserId(userId, inviteUserId);
    }
}
