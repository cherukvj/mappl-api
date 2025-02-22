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

import com.platform.mappl.model.LookupValue;
import com.platform.mappl.service.LookupValueService;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/api/lookup-values")
public class LookupValueController {

    private static final Logger logger = LoggerFactory.getLogger(LookupValueController.class);

    @Autowired
    private LookupValueService lookupValueService;

    @GetMapping
    public List<LookupValue> getAllLookupValues() {
        return lookupValueService.getAllLookupValues();
    }

    @GetMapping("/{id}")
    public Optional<LookupValue> getLookupValueById(@PathVariable int id) {
        return lookupValueService.getLookupValueById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LookupValue createLookupValue(@RequestBody @Valid LookupValue lookupValue, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errors.append(error.getDefaultMessage()).append(" ");
            }
            throw new ValidationException(errors.toString());
        }
        return lookupValueService.saveLookupValue(lookupValue);
    }

    @PutMapping("/{id}")
    public LookupValue updateLookupValue(@PathVariable int id, @RequestBody @Valid LookupValue lookupValue) {
        lookupValue.setId(id);
        return lookupValueService.saveLookupValue(lookupValue);
    }

    @DeleteMapping("/{id}")
    public void deleteLookupValue(@PathVariable int id) {
        lookupValueService.deleteLookupValue(id);
    }
    
    @GetMapping("/type/{id}")
    public List<LookupValue> getLookupValueByTypeId(@PathVariable int id) {
        return lookupValueService.getLookupValueByTypeId(id);
    }
}
