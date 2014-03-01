/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.util.Date;

/**
 *
 * @author Dryra
 */
public class Pension {
private int id ;
private int id_prest ;
private String adresse ;
private int telephone ;
private double prix_serv ;
private Date jour_disp ;
private String nom_prest ;
private String prenom_prest ;

    public void setNom_prest(String nom_prest) {
        this.nom_prest = nom_prest;
    }

    public void setPrenom_prest(String prenom_prest) {
        this.prenom_prest = prenom_prest;
    }

    public String getNom_prest() {
        return nom_prest;
    }

    public String getPrenom_prest() {
        return prenom_prest;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_prest(int id_prest) {
        this.id_prest = id_prest;
    }

    public void setJour_disp(Date jour_disp) {
        this.jour_disp = jour_disp;
    }

    public void setPrix_serv(double prix_serv) {
        this.prix_serv = prix_serv;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getId() {
        return id;
    }

    public int getId_prest() {
        return id_prest;
    }

    public Date getJour_disp() {
        return jour_disp;
    }

    public double getPrix_serv() {
        return prix_serv;
    }

    public int getTelephone() {
        return telephone;
    }


}
