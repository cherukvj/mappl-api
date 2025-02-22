package com.platform.mappl.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.mappl.model.UserInvite;
import com.platform.mappl.repository.UserInviteRepository;

@Service
public class UserInviteService {

    private static final Logger logger = LoggerFactory.getLogger(UserInviteService.class);

    @Autowired
    private UserInviteRepository userInviteRepository;

    public List<UserInvite> getAllUserInvites() {
        logger.info("Fetching all user invites");
        return userInviteRepository.findAll();
    }

    public Optional<UserInvite> getUserInviteById(int id) {
        logger.info("Fetching user invite with ID {}", id);
        return userInviteRepository.findById(id);
    }

    public UserInvite saveUserInvite(UserInvite userInvite) {
        logger.info("Saving user invite: {}", userInvite);
        return userInviteRepository.save(userInvite);
    }

    public void deleteUserInvite(int id) {
        logger.info("Deleting user invite with ID {}", id);
        userInviteRepository.deleteById(id);
    }

    public List<UserInvite> getUserInviteByUserId(int userId) {
        logger.info("Fetching user invites with User ID {}", userId);
        return userInviteRepository.findByAppUserId(userId);
    }
    
    public UserInvite getUserInviteByUserIdAndInviteUserId(int userId, int inviteUserId) {
        logger.info("Fetching user invite with User ID {} and Invite User Id {}", userId, inviteUserId);
        return userInviteRepository.findByAppUserIdAndInviteUserId(userId, inviteUserId);
    }
}
