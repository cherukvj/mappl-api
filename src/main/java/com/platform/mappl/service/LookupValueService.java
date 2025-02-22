package com.platform.mappl.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.mappl.model.LookupValue;
import com.platform.mappl.repository.LookupValueRepository;

@Service
public class LookupValueService {

    private static final Logger logger = LoggerFactory.getLogger(LookupValueService.class);

    @Autowired
    private LookupValueRepository lookupValueRepository;

    public List<LookupValue> getAllLookupValues() {
        logger.info("Fetching all lookup values");
        return lookupValueRepository.findAll();
    }

    public Optional<LookupValue> getLookupValueById(int id) {
        logger.info("Fetching lookup value with ID {}", id);
        return lookupValueRepository.findById(id);
    }

    public LookupValue saveLookupValue(LookupValue lookupValue) {
        logger.info("Saving lookup value: {}", lookupValue.getName());
        return lookupValueRepository.save(lookupValue);
    }

    public void deleteLookupValue(int id) {
        logger.info("Deleting lookup value with ID {}", id);
        lookupValueRepository.deleteById(id);
    }
    
    public List<LookupValue> getLookupValueByTypeId(int id) {
        logger.info("Fetching lookup value with Type ID {}", id);
        return lookupValueRepository.findByLookupTypeId(id);
    }
}
