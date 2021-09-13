package com.alhous.vision.visioncore.service;

import java.util.List;

import com.alhous.vision.visioncore.dao.AdminRepository;
import com.alhous.vision.visioncore.dao.MembreRepository;
import com.alhous.vision.visioncore.entite.Admin;
import com.alhous.vision.visioncore.entite.Membre;
import com.alhous.vision.visioncore.entite.Photo;
import com.alhous.vision.visioncore.util.Utilities.EtatMembre;
import com.alhous.vision.visioncore.util.Utilities.EtatPhoto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminImpl implements IAdmin {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private MembreRepository membreRepository;

    @Override
    public void ajouterAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public void supprimerAdmin(Long id) {
        adminRepository.deleteById(id);

    }

    @Override
    public void supprimerMembre(Long id) {
        membreRepository.deleteById(id);
    }

    @Override
    public void activerCompteMembre(Long id) {
        Membre m = membreRepository.findById(id).get();
        m.setEtatMembre(EtatMembre.ACTIVE);
        membreRepository.save(m);

    }

    @Override
    public void desactiverCompteMembre(Long id) {
        Membre m = membreRepository.findById(id).get();
        m.setEtatMembre(EtatMembre.SUSPENDU);
        membreRepository.save(m); 
    }

    @Override
    public void validerPhoto(Long idMembre, List<Photo> photos) {
        Membre m = membreRepository.findById(idMembre).get();
        photos.iterator().forEachRemaining(p -> {
            m.getPhotos().stream().filter(ph -> ph.getId() == p.getId()).findFirst()
                    .ifPresent(pho -> pho.setEtatPhoto(EtatPhoto.VALID));
        });
        membreRepository.save(m); 
    }

}
