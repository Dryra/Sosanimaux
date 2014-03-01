/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Entities.Prestataire;
import Util.MyConnection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author user
 */
public class PrestataireDAO {

    public boolean findPrestatairetByLogin(String email,String mdp) {

        String requete = "select * from prestataire where email=? and mdp=?";
        try {
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, email);
            ps.setString(2, mdp);
            ResultSet resultat = ps.executeQuery();
            if (resultat.next() == false) {
                System.out.println("login incorrect");
                return false;
            } else {
                System.out.println("login correct");
                return true;
            }

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du prestataire " + ex.getMessage());
            return false;
        }
    }


    public void insert(Prestataire p){

        String requete = "insert into prestataire (nom,prenom,mdp,adr,domaine,email) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getMdp());
            ps.setString(4, p.getAdresse());
            ps.setString(5, p.getDomaine());
            ps.setString(6, p.getEmail());

            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }

public String mail(String email){
    Prestataire prest = new Prestataire();
    String retour="";
    int checkmail=0 ;

     String requete = "select count(*) from prestataire where email=?";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, email);
            ResultSet resultat = ps.executeQuery();
            if (resultat.next())
            {
            checkmail=resultat.getInt(1);
            if (checkmail>0)
              retour="yes";

            }
return retour ;



        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            retour="no";
             return retour ;
        }

    }





}
