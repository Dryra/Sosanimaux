/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * @author Dryra
 */
public class Prestataire {

   

    private String nom;
    private String prenom;
    private String mdp;
    private String adresse;
    private String domaine;
    private String email;
    private int telephone ;
    private String jour_disp;
    private double prix_serv ;
    private int id ;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setJour_disp(String jour_disp) {
        this.jour_disp = jour_disp;
    }

    public void setPrix_serv(double prix_serv) {
        this.prix_serv = prix_serv;
    }

    public String getJour_disp() {
        return jour_disp;
    }

    public double getPrix_serv() {
        return prix_serv;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getTelephone() {
        return telephone;
    }

    public Prestataire()
    {}

        public String getAdresse() {
            return adresse;
        }

        public String getDomaine() {
            return domaine;
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

        public String getPrenom() {
            return prenom;
        }

        public void setAdresse(String adresse) {
            this.adresse = adresse;
        }

        public void setDomaine(String domaine) {
            this.domaine = domaine;
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

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

    
}
