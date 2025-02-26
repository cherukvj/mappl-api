package com.platform.mappl.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.mappl.model.AppUser;
import com.platform.mappl.repository.AppUserRepository;

@Service
public class AppUserService {

    private static final Logger logger = LoggerFactory.getLogger(AppUserService.class);

    @Autowired
    private AppUserRepository appUserRepository;

    public List<AppUser> getAllUsers() {
        logger.info("Fetching all users");
        return appUserRepository.findAll();
    }

    public Optional<AppUser> getUserById(int id) {
        logger.info("Fetching user with ID {}", id);
        return appUserRepository.findById(id);
    }

    public AppUser saveUser(AppUser appUser) {
        logger.info("Saving user: {}", appUser.getPhone());
        return appUserRepository.save(appUser);
    }

    public void deleteUser(int id) {
        logger.info("Deleting user with ID {}", id);
        appUserRepository.deleteById(id);
    }
    
    public boolean verifyProfileName(String profileName) {
        logger.info("Verify profile name {}", profileName);
        return appUserRepository.existsByProfileNameIgnoreCase(profileName.trim());
    }
    
    public void updateLocation(String location, int userId) {
        logger.info("Update location for user {}", userId);
        appUserRepository.updateLocation(location, userId);
    }
    
    public AppUser getUserByPhone(String phone) {
        logger.info("Fetching user with phone {}", phone);
        return appUserRepository.findByPhone(phone);
    }
}