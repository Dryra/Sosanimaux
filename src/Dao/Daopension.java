/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Entities.Pension;
import Util.MyConnection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Dryra
 */
public class Daopension {




    public List<Pension> getpension()  {
        String requete = "select p.id,p.id_prest,p.adr,p.tel,p.prix_serv,p.jour_disp,pr.nom,pr.prenom from pensions p , prestataire pr where p.id_prest=pr.id ";
        List<Pension> ag = new ArrayList<Pension>();

        try {
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                Pension p = new Pension();
                p.setId(resultat.getInt("id"));
               p.setNom_prest(resultat.getString("nom"));
                p.setPrenom_prest(resultat.getString("prenom"));

                p.setAdresse(resultat.getString("adr"));
p.setTelephone(resultat.getInt("tel"));
                p.setPrix_serv(resultat.getDouble("prix_serv"));
                p.setJour_disp(resultat.getDate("jour_disp"));



                ag.add(p);





            }
            return ag;





        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
            return null;

        }

    }






    public void supprimerpens(int id_pens) {
        String requete = " delete from pensions where id=? ";


        try {
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
ps.setInt(1,id_pens);






             ps.executeUpdate();







        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());


        }

    }



    public void updatepens(List<String> l){

        String requete = "update pensions set adr=? , tel=?, prix_serv=?, jour_disp=? where id=?";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, l.get(0));
            ps.setInt(2, Integer.parseInt(l.get(1)));
            ps.setDouble(3, Double.parseDouble(l.get(2)));
            ps.setDate(4, Date.valueOf(l.get(3)));
            ps.setInt(5, Integer.parseInt(l.get(4)));

            



            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }






}
