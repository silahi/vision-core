package com.alhous.vision.visioncore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alhous.vision.visioncore.dao.AdminRepository;
import com.alhous.vision.visioncore.dao.MembreRepository;
import com.alhous.vision.visioncore.dao.PhotoRepository;
import com.alhous.vision.visioncore.entite.Admin;
import com.alhous.vision.visioncore.entite.Photo;
import com.alhous.vision.visioncore.service.IAdmin;
import com.alhous.vision.visioncore.util.Utilities.EtatPhoto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminImplTest {
    @Autowired
    private IAdmin admin;

    @Autowired
    PhotoRepository photoRepository;

    @Autowired
    MembreRepository membreRepository;

    @Autowired
    AdminRepository adminRepository;
    Admin a = new Admin("Silahi", "Silahi", "silahi@gmail.com", "781585647", "1234", new Date());

    @Test
    void ajouterAdmin() {
        admin.ajouterAdmin(a);
    }

    @Test
    void activerCompteMembre() {
        admin.activerCompteMembre(2L);
    }

    @Test
    void validerPhoto() {
        List<Photo> photos = new ArrayList<>();
        photoRepository.findAll().iterator().forEachRemaining(p -> {
            if (p.getEtatPhoto().equals(EtatPhoto.INVALID)) {
                photos.add(p);
            }
        });
        admin.validerPhoto(2L, photos);
    }

    @Test
    void supprimerMembre() {
        admin.supprimerMembre(2L);
    }

}
