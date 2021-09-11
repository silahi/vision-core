package com.alhous.vision.visioncore.entite;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.alhous.vision.visioncore.util.Utilities.EtatPhoto;

@Entity
public class Photo {
    @Id
    @GeneratedValue
    private Long id;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] pixels;
    private String categorie;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAjout;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateValide;
    private EtatPhoto etatPhoto = EtatPhoto.INVALID;

    public Photo(byte[] pixels, String categorie, Date dateAjout, Date dateValide) {
        this.pixels = pixels;
        this.categorie = categorie;
        this.dateAjout = dateAjout;
        this.dateValide = dateValide;
    }

    public Photo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getPixels() {
        return pixels;
    }

    public void setPixels(byte[] pixels) {
        this.pixels = pixels;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public EtatPhoto getEtatPhoto() {
        return etatPhoto;
    }

    public void setEtatPhoto(EtatPhoto etatPhoto) {
        this.etatPhoto = etatPhoto;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Date getDateValide() {
        return dateValide;
    }

    public void setDateValide(Date dateValide) {
        this.dateValide = dateValide;
    }

    @Override
    public String toString() {
        return "Photo [categorie=" + categorie + ", dateAjout=" + dateAjout + ", dateValide=" + dateValide + ", id="
                + id + ", pixels=" + Arrays.toString(pixels) + ", etatPhoto=" + etatPhoto + "]";
    }

}
