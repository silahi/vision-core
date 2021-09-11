package com.alhous.vision.visioncore.dao;

import com.alhous.vision.visioncore.entite.Photo;

import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Long> {
    
}
