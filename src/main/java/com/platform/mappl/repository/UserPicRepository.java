package com.platform.mappl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.mappl.model.UserPic;

@Repository
public interface UserPicRepository extends JpaRepository<UserPic, Integer> {

	List<UserPic> findByAppUserId(int appUserId);
}