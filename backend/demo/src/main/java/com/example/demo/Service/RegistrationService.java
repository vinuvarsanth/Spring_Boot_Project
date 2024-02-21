package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Model.RegistrationEntity;
import com.example.demo.Repository.RegistrationRepo;

public class RegistrationService {
    
    @Autowired
    RegistrationRepo repo;
    public RegistrationEntity update(int id, RegistrationEntity mod) {
        RegistrationEntity model = repo.findById(id).orElse(null);
        if (model != null) {
            model.setName(mod.getName());
            repo.save(model);
            return model;
        } else
            return mod;

    }
}
