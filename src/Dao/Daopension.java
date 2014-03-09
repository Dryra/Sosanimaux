/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Entities.Pension;
import Util.MyConnection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.FileNotFoundException;
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
        String requete = "select p.id,p.id_prest,p.adr,p.tel,p.prix_pens,p.jour_disp,pr.nom,pr.prenom from pensions p , prestataire pr where p.id_prest=pr.id ";
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
                
                p.setJour_disp(resultat.getString("jour_disp"));
                p.setPrix_pens(resultat.getDouble("prix_pens"));



                ag.add(p);





            }
            return ag;





        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
            return null;

        }

    }




    public List<Pension> getpensionbyid(int id_presta)  {
        String requete = "select p.id,p.id_prest,p.adr,p.tel,p.prix_pens,p.jour_disp,pr.nom,pr.prenom from pensions p , prestataire pr where p.id_prest=pr.id and id_prest="+id_presta+ ";";
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

                p.setJour_disp(resultat.getString("jour_disp"));
                p.setPrix_pens(resultat.getDouble("prix_pens"));



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

    public List<Pension> getAll() {
        String query = "select * from pensions ";
        Pension pensions = new Pension();
        List<Pension> listpension = new ArrayList<Pension>();
        try {
            Statement s = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = s.executeQuery(query);
            while (resultat.next()) {
                pensions.setId(resultat.getInt("id"));
                pensions.setAdresse(resultat.getString("adr"));
                pensions.setTelephone(resultat.getInt("tel"));
                
                pensions.setJour_disp(resultat.getString("jour_disp"));


                listpension.add(pensions);

            }
            return listpension;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public void insertpension(Pension p,int id_pres) throws FileNotFoundException, SQLException  {

        String requete = "insert into pensions (nom,prix_pens,jour_disp,tel,adr,id_prest) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrix_pens());
            ps.setString(3, p.getJour_disp());
            ps.setInt(4, p.getTelephone());
            ps.setString(5, p.getAdresse());
           
            ps.setInt(6, id_pres);
            
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion pension "+ex.getMessage());
        }
    }

    

    

    public void deletePension(String nom) {
        String requete = "delete * from pensions where nom= '"+ nom + "' ;";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1,nom);
            ps.executeUpdate();
            System.out.println("Pension supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors de la suppression " + ex.getMessage());
        }
    }

    


    
    


    

    
////////////////////////////////////


    //////////////////////////////



    public void updatePension(Pension d) {

   Daopension psDAO = new Daopension();

  int id = psDAO.getIdFromName(d.getNom());

  String requete = "update pensions set nom=?, adr=? , tel=? , prix_pens=?, id_prest=? where  id = "+id+" ;";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            System.out.println("NOM "+d.getNom());
            ps.setString(1, d.getNom());
            ps.setString(2, d.getAdresse());
            ps.setInt(3, d.getTelephone());
            ps.setDouble(4, d.getPrix_pens());
            ps.setDouble(5, d.getId_prest());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'UPDATE " + ex.getMessage());
        }
    }

    public int getIdFromName(String name){


        String requete = "Select id from pensions where nom = '"+name+"' ;";
        int i = 0;
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                i=resultat.getInt(1);
            }
            return i;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de ID pension " + ex.getMessage());
            return 0;
        }
    }

    public void deletePension(int id) {
        System.out.println("ID" + id);
        String requete = "delete from pensions where id= ? ;";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Pension supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors de la suppression " + ex.getMessage());
        }
    }

    public List<Pension> AfficherAllPension(){
         List<Pension> pensions = new ArrayList<Pension>();
        String requete = "Select * from pensions";

        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Pension pens= new Pension() ;
                pens.setId(resultat.getInt("id"));
                pens.setId_prest(resultat.getInt("id_prest"));
                pens.setAdresse(resultat.getString("adr"));
                pens.setTelephone(resultat.getInt("tel"));
                pens.setNom(resultat.getString("nom"));
                pens.setPrix_pens(resultat.getDouble("prix_pens"));

            pensions.add(pens);
            }
            return pensions ;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }


    public List<Pension> AfficherPensionByAdrresse(String adr){
         List<Pension> pensions = new ArrayList<Pension>();
        String requete = "Select * from pensions where adr = '"+adr+"' ;";

        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Pension pens= new Pension() ;
                pens.setId(resultat.getInt("id"));
                pens.setId_prest(resultat.getInt("id_prest"));
                pens.setAdresse(resultat.getString("adr"));
                pens.setTelephone(resultat.getInt("tel"));
                pens.setNom(resultat.getString("nom"));
                pens.setPrix_pens(resultat.getDouble("prix_pens"));
            pensions.add(pens);
            }
            return pensions ;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

    public Pension AfficherPensionByID(int id){
        String requete = "Select * from pensions where id = "+id+" ;";
        Pension pens= new Pension() ;
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {

                pens.setId(resultat.getInt("id"));
                pens.setNom(resultat.getString("nom"));
                pens.setAdresse(resultat.getString("adr"));
                pens.setTelephone(resultat.getInt("tel"));
                pens.setPrix_pens(resultat.getDouble("prix_pens"));
                pens.setId_prest(resultat.getInt("id_prest"));

            }
            return pens ;

        } catch (SQLException ex) {
            System.out.println("erreur " + ex.getMessage());
            return null;
        }
    }


    public void insertPension(Pension d){

        String requete = "insert into pensions (nom,adr,tel,prix_pens,id_prest) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, d.getNom());
            ps.setString(2, d.getAdresse());
            ps.setInt(3, d.getTelephone());
            ps.setDouble(4, d.getPrix_pens());
            ps.setInt(5, d.getId_prest());


            int executeUpdate = ps.executeUpdate();

           //if(executeUpdate==0)
            System.out.println("Ajout effectuée avec succès =>"+executeUpdate);

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }

    public static void main(String[] args) {



    }


public List<Pension> listePension()  {
        String requete = "select * from pensions ";
        List<Pension> lp = new ArrayList<Pension>();

        try {
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                Pension p = new Pension();
                p.setId(resultat.getInt("id"));
                p.setNom(resultat.getString("nom"));
                p.setAdresse(resultat.getString("adr"));
                p.setTelephone(resultat.getInt("tel"));
                p.setJour_disp(resultat.getString("jour_disp"));
                p.setPrix_pens(resultat.getDouble("prix_pens"));
                
              lp.add(p);


            }
            return lp;


        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
            return null;

        }

    }











}
