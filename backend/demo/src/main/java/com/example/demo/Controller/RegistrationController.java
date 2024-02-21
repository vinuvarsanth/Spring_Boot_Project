package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.RegistrationEntity;
import com.example.demo.Repository.RegistrationRepo;

@RestController
public class RegistrationController {
    @Autowired
    RegistrationRepo repo;
    @GetMapping("/details")
    public List<RegistrationEntity> getDetails() {
        List<RegistrationEntity> registrationEntities = repo.findAll();
        return registrationEntities;
    }

    @GetMapping("/details/{id}")
    public RegistrationEntity getRegistrationEntity(@PathVariable int id) {
        RegistrationEntity registrationEntity = repo.findById(id).get();
        return registrationEntity;
    }

    @PostMapping("/details/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createRegistrationEntity(@RequestBody RegistrationEntity registrationEntity) {
        repo.save(registrationEntity);
    }
    
    @PutMapping("/details/update/{id}")
public ResponseEntity<RegistrationEntity> updateRegistrationEntity(@PathVariable int id, @RequestBody RegistrationEntity updatedEntity) {
    RegistrationEntity registrationEntity = repo.findById(id).orElse(null);
    if (registrationEntity != null) {
        // Update the fields of the existing entity
        if (updatedEntity.getName() != null && !updatedEntity.getName().isEmpty()) {
            registrationEntity.setName(updatedEntity.getName());
        }
        if (updatedEntity.getEmail() != null && !updatedEntity.getEmail().isEmpty()) {
            registrationEntity.setEmail(updatedEntity.getEmail());
        }
        if (updatedEntity.getGender() != null && !updatedEntity.getGender().isEmpty()) {
            registrationEntity.setGender(updatedEntity.getGender());
        }
        if (updatedEntity.getPhoneNumber() != 0) {
            registrationEntity.setPhoneNumber(updatedEntity.getPhoneNumber());
        }
        if (updatedEntity.getPassword() != null && !updatedEntity.getPassword().isEmpty()) {
            registrationEntity.setPassword(updatedEntity.getPassword());
        }
        // Update other fields as needed

        // Save the updated entity to the database
        registrationEntity = repo.save(registrationEntity);
        return ResponseEntity.ok(registrationEntity);
    } else {
        return ResponseEntity.notFound().build();
    }
}



    @DeleteMapping("/details/delete/{id}")
    public void removeRegistrationEntity(@PathVariable int id) {
        RegistrationEntity registrationEntity = repo.findById(id).get();
        repo.delete(registrationEntity);
    }
}
