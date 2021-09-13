package com.alhous.vision.visioncore;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.alhous.vision.visioncore.dao.AdminRepository;
import com.alhous.vision.visioncore.dao.MembreRepository;
import com.alhous.vision.visioncore.entite.Admin;
import com.alhous.vision.visioncore.entite.Membre;
import com.alhous.vision.visioncore.entite.Photo;
import com.alhous.vision.visioncore.service.IMembre;
import com.github.javafaker.Faker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class VisionCoreApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(VisionCoreApplication.class, args);

		AdminRepository adminRepository = ctx.getBean(AdminRepository.class);
		MembreRepository membreRepository = ctx.getBean(MembreRepository.class);
		IMembre iMembre = ctx.getBean(IMembre.class);

		Locale france = Locale.FRANCE;
		Faker faker = new Faker(france);

		for (int i = 0; i < 10; i++) {
			Membre m = new Membre();
			m.setNom(faker.name().firstName());
			m.setPrenom(faker.name().lastName());
			m.setTelephone(faker.phoneNumber().phoneNumber());
			m.setEmail(m.getNom() + "." + m.getPrenom() + "@gmail.com");
			m.setDepuis(faker.date().birthday());
			m.setMotDePasse(faker.crypto().md5());
			membreRepository.save(m);
		}

		for (int i = 0; i < 3; i++) {
			Admin m = new Admin();
			m.setNom(faker.name().firstName());
			m.setPrenom(faker.name().lastName());
			m.setTelephone(faker.phoneNumber().phoneNumber());
			m.setEmail(m.getNom() + "." + m.getPrenom() + "@gmail.com");
			m.setDepuis(faker.date().birthday());
			m.setMotDePasse(faker.crypto().md5());
			adminRepository.save(m);
		}

		List<Photo> photos = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Photo ph = new Photo();
			ph.setCategorie(faker.animal().name());
			photos.add(ph);
		}

		long id = faker.number().numberBetween(1, 10);
		iMembre.uploadPhotos(id, photos);
	}

}
