package com.alhous.vision.visioncore.dao;

import com.alhous.vision.visioncore.entite.Photo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    
}
