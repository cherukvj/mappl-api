package com.platform.mappl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.mappl.model.UserInvite;

@Repository
public interface UserInviteRepository extends JpaRepository<UserInvite, Integer> {

	List<UserInvite> findByAppUserId(int appUserId);
	
	UserInvite findByAppUserIdAndInviteUserId(int appUserId, int inviteUserId);
}