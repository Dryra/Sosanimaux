/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * @author Dryra
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Image;

/**
 *
 * @author Dryra
 */
public class adherant {

    private String nom;
    private String prenom;
    private String mdp;
    private String adresse;
    private String email;
    private int numero ;
    private Image photo ;
    private String ville ;
    private String Sexe ;
    private int telephone ;
    private int age ;
    private int id ;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getVille() {
        return ville;
    }
    public adherant() {}

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getNom() {
        return nom;
    }

    public int getNumero() {
        return numero;
    }

    public String getPrenom() {
        return prenom;
    }

}

