package com.platform.mappl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.mappl.model.LookupValue;

@Repository
public interface LookupValueRepository extends JpaRepository<LookupValue, Integer> {
	List<LookupValue> findByLookupTypeId(int lookupTypeId);
}