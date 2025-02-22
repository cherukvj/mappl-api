package com.platform.mappl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.platform.mappl.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
	boolean existsByProfileNameIgnoreCase(String profileName);
	
	@Modifying
	@Query("update AppUser u set u.location = :location where u.id = :id")
	int updateLocation(@Param("location") String location, @Param("id") Integer id);
}