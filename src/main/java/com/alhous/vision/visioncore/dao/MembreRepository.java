package com.alhous.vision.visioncore.dao;

import com.alhous.vision.visioncore.entite.Membre;

import org.springframework.data.repository.CrudRepository;

public interface MembreRepository extends CrudRepository<Membre, Long> {
    
}
