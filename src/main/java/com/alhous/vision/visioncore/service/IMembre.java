package com.alhous.vision.visioncore.service;

import java.util.List;

import com.alhous.vision.visioncore.entite.Membre;
import com.alhous.vision.visioncore.entite.Photo;

public interface IMembre {
    void devenirMembre(Membre membre);

    void uploadPhotos(Long idMembre, List<Photo> photos);
}
