package com.alhous.vision.visioncore.controller;

import java.util.List;

import com.alhous.vision.visioncore.dao.MembreRepository;
import com.alhous.vision.visioncore.entite.Membre;
import com.alhous.vision.visioncore.exceptions.MembreNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MembreController {
    @Autowired
    MembreRepository membreRepository;

    @GetMapping("/membres")
    List<Membre> tousLesMembres() {
        return membreRepository.findAll();
    }

    @PostMapping("/membres")
    Membre nouveauMembre(@RequestBody Membre nouveauMembre) {
        return membreRepository.save(nouveauMembre);
    }

    @GetMapping("/membres/{id}")
    Membre getMembre(@PathVariable Long id) {
        String message = "Aucun membre associé à cet identifiant : " + id;
        return membreRepository.findById(id).orElseThrow(() -> new MembreNotFoundException(message));

    }

    @PutMapping("/membres/{id}")
    Membre modifieMembre(@RequestBody Membre nouveauMembre, @PathVariable Long id) {
        return membreRepository.findById(id).map(membre -> {
            membre = nouveauMembre;
            return membreRepository.save(membre);
        }).orElseGet(() -> {
            nouveauMembre.setId(id);
            return membreRepository.save(nouveauMembre);
        });
    }

    @DeleteMapping("/membres/{id}")
    void supprimerMembre(@PathVariable Long id) {
        membreRepository.deleteById(id);
    }

}
