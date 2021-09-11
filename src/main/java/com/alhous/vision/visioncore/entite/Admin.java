package com.alhous.vision.visioncore.entite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Admin {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String motDePasse;

    @Temporal(TemporalType.TIMESTAMP)
    private Date depuis;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Photo> photos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Membre> membres = new ArrayList<>();

    public Admin() {
    }

    public Admin(String nom, String prenom, String email, String telephone, String motDePasse, Date depuis) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.depuis = depuis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Date getDepuis() {
        return depuis;
    }

    public void setDepuis(Date depuis) {
        this.depuis = depuis;
    }

    @Override
    public String toString() {
        return "Admin [depuis=" + depuis + ", email=" + email + ", id=" + id + ", motDePasse=" + motDePasse + ", nom="
                + nom + ", prenom=" + prenom + ", telephone=" + telephone + "]";
    }

    public List<Membre> getMembres() {
        return membres;
    }

    public void setMembres(List<Membre> membres) {
        this.membres = membres;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    

}
