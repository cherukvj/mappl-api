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

import com.platform.mappl.model.AppUser;
import com.platform.mappl.service.AppUserService;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private static final Logger logger = LoggerFactory.getLogger(AppUserController.class);

    @Autowired
    private AppUserService appUserService;

    @GetMapping
    public List<AppUser> getAllUsers() {
        return appUserService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<AppUser> getUserById(@PathVariable int id) {
        return appUserService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppUser createUser(@RequestBody @Valid AppUser appUser, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errors.append(error.getDefaultMessage()).append(" ");
            }
            throw new ValidationException(errors.toString());
        }
        return appUserService.saveUser(appUser);
    }

    @PutMapping("/{id}")
    public AppUser updateUser(@PathVariable int id, @RequestBody @Valid AppUser appUser) {
        appUser.setId(id);
        return appUserService.saveUser(appUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        appUserService.deleteUser(id);
    }
    
    @GetMapping("/verify/{profileName}")
    public Boolean verifyProfileName(@PathVariable String profileName) {
        return appUserService.verifyProfileName(profileName);
    }
    
    @GetMapping("/{id}/location/{location}")
    public void getUserById(@PathVariable Integer id, @PathVariable String location) {
        appUserService.updateLocation(location, id);
    }
    
    @GetMapping("/sendotp/{phone}")
    public void sendOTP(@PathVariable String phone) {
    	// TODO: SMS integration
    }
    
    @GetMapping("/verifyotp/{otp}")
    public Boolean verifyOTP(@PathVariable String otp) {
    	return otp.equals("123456");
    }
    
    @GetMapping("/phone/{phone}")
    public AppUser getUserByPhone(@PathVariable String phone) {
        return appUserService.getUserByPhone(phone);
    }
}
