package com.alhous.vision.visioncore.controller;
import java.util.List;

import com.alhous.vision.visioncore.dao.AdminRepository;
import com.alhous.vision.visioncore.entite.Admin;
import com.alhous.vision.visioncore.exceptions.AdminNotFoundException;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; 

@RestController
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/admins")
    public List<Admin> tousLesAdmins() {
        return adminRepository.findAll();
    }

    @PostMapping("/admins")
    Admin nouvelAdmin(@RequestBody Admin nouvelAdmin) {
        return adminRepository.save(nouvelAdmin);
    }

    @GetMapping("/admins/{id}")
    Admin getAdmin(@PathVariable Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new AdminNotFoundException(id));
    }

    @PutMapping("/admins/{id}")
    Admin modifierAdmin(@RequestBody Admin nouvelAdmin, @PathVariable Long id) {
        return adminRepository.findById(id).map(admin -> {
            admin = nouvelAdmin;
            return adminRepository.save(admin);
        }).orElseGet(() -> {
            nouvelAdmin.setId(id);
            return adminRepository.save(nouvelAdmin);
        });
    }

    @DeleteMapping("/admins/{id}")
    void supprimerAdmin(@PathVariable Long id) {
        adminRepository.deleteById(id);
    }
}
