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

@Entity
public class Photo {
    @Id
    @GeneratedValue
    private Long id;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] pixels;
    private String categorie;
    private boolean valid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAjout;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateValide;

    public Photo(byte[] pixels, String categorie, boolean valid, Date dateAjout, Date dateValide) {
        this.pixels = pixels;
        this.categorie = categorie;
        this.valid = valid;
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

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
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
                + id + ", pixels=" + Arrays.toString(pixels) + ", valid=" + valid + "]";
    }

}
