package com.platform.mappl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.mappl.model.LookupType;

@Repository
public interface LookupTypeRepository extends JpaRepository<LookupType, Integer> {
	
}