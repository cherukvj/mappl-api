package com.platform.mappl.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.mappl.model.LookupType;
import com.platform.mappl.repository.LookupTypeRepository;

@Service
public class LookupTypeService {

    private static final Logger logger = LoggerFactory.getLogger(LookupTypeService.class);

    @Autowired
    private LookupTypeRepository lookupTypeRepository;

    public List<LookupType> getAllLookupTypes() {
        logger.info("Fetching all lookup types");
        return lookupTypeRepository.findAll();
    }

    public Optional<LookupType> getLookupTypeById(int id) {
        logger.info("Fetching lookup type with ID {}", id);
        return lookupTypeRepository.findById(id);
    }

    public LookupType saveLookupType(LookupType lookupType) {
        logger.info("Saving lookup type: {}", lookupType.getName());
        return lookupTypeRepository.save(lookupType);
    }

    public void deleteLookupType(int id) {
        logger.info("Deleting lookup type with ID {}", id);
        lookupTypeRepository.deleteById(id);
    }
}
