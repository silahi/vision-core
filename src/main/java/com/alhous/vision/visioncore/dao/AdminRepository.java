package com.alhous.vision.visioncore.dao;

import com.alhous.vision.visioncore.entite.Admin;

import org.springframework.data.jpa.repository.JpaRepository; 

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}
