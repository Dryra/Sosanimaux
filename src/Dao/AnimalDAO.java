/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import Util.MyConnection;
/**
 *
 * @author Dryra
 */
public class AnimalDAO {

    public int getAnimalEtatPerdu() {

        String requete = "select * from animal where etat='perdu';";
        try {
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();

            int nb = 0;
            while (resultat.next()) {
                nb = nb + 1;
            }
            return nb;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des animals perdus " + ex.getMessage());
            return -1;
        }
    }

    public int getAnimalEtatSansRefuge() {

        String requete = "select * from animal where etat='sans refuge';";
        try {
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();

            int nb = 0;
            while (resultat.next()) {
                nb = nb + 1;
            }
            return nb;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des animals sans refuges " + ex.getMessage());
            return -1;
        }
    }

    public int getAnimalEtatSansFoyer() {

        String requete = "select * from animal where etat='sans foyer';";
        try {
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();

            int nb = 0;
            while (resultat.next()) {
                nb = nb + 1;
            }
            return nb;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des animaux sans foyer " + ex.getMessage());
            return -1;
        }
    }


}
