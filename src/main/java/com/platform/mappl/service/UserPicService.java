package com.platform.mappl.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.mappl.model.UserPic;
import com.platform.mappl.repository.UserPicRepository;

@Service
public class UserPicService {

    private static final Logger logger = LoggerFactory.getLogger(UserPicService.class);

    @Autowired
    private UserPicRepository userPicRepository;

    public List<UserPic> getAllUserPics() {
        logger.info("Fetching all user pictures");
        return userPicRepository.findAll();
    }

    public Optional<UserPic> getUserPicById(int id) {
        logger.info("Fetching user picture with ID {}", id);
        return userPicRepository.findById(id);
    }

    public UserPic saveUserPic(UserPic userPic) {
        logger.info("Saving user picture");
        return userPicRepository.save(userPic);
    }

    public void deleteUserPic(int id) {
        logger.info("Deleting user picture with ID {}", id);
        userPicRepository.deleteById(id);
    }

    public List<UserPic> getUserPicByUserId(int userId) {
        logger.info("Fetching user pictures with User ID {}", userId);
        return userPicRepository.findByAppUserId(userId);
    }
}
