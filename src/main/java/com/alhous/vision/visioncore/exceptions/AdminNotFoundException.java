package com.alhous.vision.visioncore.exceptions;

public class AdminNotFoundException extends RuntimeException {

    public AdminNotFoundException(Long id) {
        super("Aucun un admin correspond à cet identifiant : " + id);
    }

}
