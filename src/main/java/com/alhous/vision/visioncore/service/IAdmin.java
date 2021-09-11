package com.alhous.vision.visioncore.service;

import java.util.List;

import com.alhous.vision.visioncore.entite.Admin;
import com.alhous.vision.visioncore.entite.Photo;

public interface IAdmin {
    void ajouterAdmin(Admin admin);

    void supprimerAdmin(Long id);

    void supprimerMembre(Long id);

    void activerCompteMembre(Long id);

    void desactiverCompteMembre(Long id);

    void validerPhoto(Long idMembre, List<Photo> photos);
}
