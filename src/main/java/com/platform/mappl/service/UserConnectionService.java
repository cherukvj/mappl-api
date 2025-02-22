package com.platform.mappl.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.mappl.model.UserConnection;
import com.platform.mappl.repository.UserConnectionRepository;

@Service
public class UserConnectionService {

    private static final Logger logger = LoggerFactory.getLogger(UserConnectionService.class);

    @Autowired
    private UserConnectionRepository userConnectionRepository;

    public List<UserConnection> getAllUserConnections() {
        logger.info("Fetching all user connections");
        return userConnectionRepository.findAll();
    }

    public Optional<UserConnection> getUserConnectionById(int id) {
        logger.info("Fetching user connection with ID {}", id);
        return userConnectionRepository.findById(id);
    }

    public UserConnection saveUserConnection(UserConnection userConnection) {
        logger.info("Saving user connection: {}", userConnection);
        return userConnectionRepository.save(userConnection);
    }

    public void deleteUserConnection(int id) {
        logger.info("Deleting user connection with ID {}", id);
        userConnectionRepository.deleteById(id);
    }

    public List<UserConnection> getUserConnectionByUserId(int userId) {
        logger.info("Fetching user connections with User ID {}", userId);
        return userConnectionRepository.findByAppUserId(userId);
    }
}
