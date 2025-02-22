package com.platform.mappl.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.platform.mappl.model.LookupType;
import com.platform.mappl.service.LookupTypeService;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/api/lookup-types")
public class LookupTypeController {

    private static final Logger logger = LoggerFactory.getLogger(LookupTypeController.class);

    @Autowired
    private LookupTypeService lookupTypeService;

    @GetMapping
    public List<LookupType> getAllLookupTypes() {
        return lookupTypeService.getAllLookupTypes();
    }

    @GetMapping("/{id}")
    public Optional<LookupType> getLookupTypeById(@PathVariable int id) {
        return lookupTypeService.getLookupTypeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LookupType createLookupType(@RequestBody @Valid LookupType lookupType, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errors.append(error.getDefaultMessage()).append(" ");
            }
            throw new ValidationException(errors.toString());
        }
        return lookupTypeService.saveLookupType(lookupType);
    }

    @PutMapping("/{id}")
    public LookupType updateLookupType(@PathVariable int id, @RequestBody @Valid LookupType lookupType) {
        lookupType.setId(id);
        return lookupTypeService.saveLookupType(lookupType);
    }

    @DeleteMapping("/{id}")
    public void deleteLookupType(@PathVariable int id) {
        lookupTypeService.deleteLookupType(id);
    }
}
