/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Util.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class AdminDAO {

    public int findAdmintByLogin(String email, String mdp) {

        String requete = "select id from admin where login='" + email + "' and mdp='" + mdp + "'";
        int i = 0;
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

//            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
//            ps.setString(1, email);
//            ps.setString(2, mdp);
//            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                System.out.println("login correct");
                i = resultat.getInt(1);
            }
            return i;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(" erruer admin " + ex.getMessage());
            return -1;
        }
    }
}
