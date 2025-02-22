package com.platform.mappl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.mappl.model.UserConnection;

@Repository
public interface UserConnectionRepository extends JpaRepository<UserConnection, Integer> {

	List<UserConnection> findByAppUserId(int appUserId);
}