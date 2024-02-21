package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.RegistrationEntity;

@RestController
public interface RegistrationRepo extends JpaRepository<RegistrationEntity,Integer> {
    
}
