package com.alhous.vision.visioncore;

import com.alhous.vision.visioncore.dao.AdminRepository;
import com.alhous.vision.visioncore.dao.MembreRepository;
import com.alhous.vision.visioncore.service.IMembre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VisionCoreApplicationTests {

	@Autowired
	MembreRepository membreRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	private IMembre membre;
	


	 





	@Test
	void contextLoads() {
	



		Long ida = adminRepository.findAll().iterator().next().getId();
		Long idm = membreRepository.findAll().iterator().next().getId();

	}

}
