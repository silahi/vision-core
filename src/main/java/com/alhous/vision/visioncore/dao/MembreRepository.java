package com.alhous.vision.visioncore.dao;

import com.alhous.vision.visioncore.entite.Membre;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepository extends JpaRepository<Membre, Long> {
    
}
