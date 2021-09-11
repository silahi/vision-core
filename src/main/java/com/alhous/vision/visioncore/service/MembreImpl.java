package com.alhous.vision.visioncore.service;

import java.util.List;

import com.alhous.vision.visioncore.dao.MembreRepository;
import com.alhous.vision.visioncore.entite.Membre;
import com.alhous.vision.visioncore.entite.Photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembreImpl implements IMembre {
    @Autowired
    private MembreRepository membreRepository;

    @Override
    public void devenirMembre(Membre membre) {
        membreRepository.save(membre);
    }

    @Override
    public void uploadPhotos(Long idMembre, List<Photo> photos) {
        Membre m = membreRepository.findById(idMembre).get();
        photos.iterator().forEachRemaining(ph -> m.getPhotos().add(ph));
        membreRepository.save(m); 
    }

}
