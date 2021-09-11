package com.alhous.vision.visioncore;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.alhous.vision.visioncore.entite.Membre;
import com.alhous.vision.visioncore.entite.Photo;
import com.alhous.vision.visioncore.service.IMembre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MembreTest {

    @Autowired
    private IMembre membre;

    Membre m = new Membre("ali", "Ali", "silahi@gmail.com", "781585646", "1234", new Date());
    Photo photo = new Photo(null, "Chat", new Date(), null);
    List<Photo> photos = Arrays.asList(photo);

    @Test
    void devenirMembre() {
        membre.devenirMembre(m);
    }

    @Test
    void uploadPhotos(){
        membre.uploadPhotos(2L, photos);
    }
}
