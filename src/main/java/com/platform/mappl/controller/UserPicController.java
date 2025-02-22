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

import com.platform.mappl.model.UserPic;
import com.platform.mappl.service.UserPicService;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/api/user-pics")
public class UserPicController {

    private static final Logger logger = LoggerFactory.getLogger(UserPicController.class);

    @Autowired
    private UserPicService userPicService;

    @GetMapping
    public List<UserPic> getAllUserPics() {
        return userPicService.getAllUserPics();
    }

    @GetMapping("/{id}")
    public Optional<UserPic> getUserPicById(@PathVariable int id) {
        return userPicService.getUserPicById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserPic createUserPic(@RequestBody @Valid UserPic userPic, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errors.append(error.getDefaultMessage()).append(" ");
            }
            throw new ValidationException(errors.toString());
        }
        return userPicService.saveUserPic(userPic);
    }

    @PutMapping("/{id}")
    public UserPic updateUserPic(@PathVariable int id, @RequestBody @Valid UserPic userPic) {
        userPic.setId(id);
        return userPicService.saveUserPic(userPic);
    }

    @DeleteMapping("/{id}")
    public void deleteUserPic(@PathVariable int id) {
        userPicService.deleteUserPic(id);
    }

    @GetMapping("/user/{userId}")
    public List<UserPic> getUserPicByUserId(@PathVariable int userId) {
        return userPicService.getUserPicByUserId(userId);
    }
}
