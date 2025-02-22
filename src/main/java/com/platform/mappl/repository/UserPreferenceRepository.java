package com.platform.mappl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.mappl.model.UserPreference;

@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreference, Integer> {

	List<UserPreference> findByAppUserId(int appUserId);
}