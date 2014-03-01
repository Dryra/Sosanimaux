/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.awt.Image;
import java.io.File;

/**
 *
 * @author Dryra
 */
public class Animal {
private String espece;
    private String age;
    private String race;
    private String poids;
    private String couleur;
    private String vaccin ;
    private String autre ;
    private File photo ;
    private String nom ;
    private String etat ;
private String Sexe ;

   
    private int id ;
    private int id_adh;

    public void setId(int id) {
        this.id = id;
    }

    public void setId_adh(int id_adh) {
        this.id_adh = id_adh;
    }

    public int getId() {
        return id;
    }

    public int getId_adh() {
        return id_adh;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public File getPhoto() {
        return photo;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }

    public String getAutre() {
        return autre;
    }
    


    public String getSexe() {
        return Sexe;
    }

    public String getAge() {
        return age;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getEspece() {
        return espece;
    }

    public String getEtat() {
        return etat;
    }

    public String getPoids() {
        return poids;
    }

    public String getRace() {
        return race;
    }

    public String getVaccin() {
        return vaccin;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setVaccin(String vaccin) {
        this.vaccin = vaccin;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


}
