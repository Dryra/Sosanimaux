/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Entities.Prestataire;
import Util.MyConnection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author user
 */
public class PrestataireDAO {

    public int findPrestaByLogin(String email, String mdp) {

        String requete = "select * from prestataire where email='" + email + "' and mdp='" + mdp + "'";
        int i = 0;
        try {
            Statement statement = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

//            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
//            ps.setString(1, email);
//            ps.setString(2, mdp);
//            ResultSet resultat = ps.executeQuery();
            if (resultat.next() == true) {
                System.out.println("login correct");
                i = resultat.getInt("id");

            } else {

                return -1 ;
            }
            return i;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(" erruer presta " + ex.getMessage());
            return -1;
        }
    }


     public void insertprestataire(Prestataire I)  {

        String requete = "insert into prestataire (nom,prenom,mdp,adr,tel,email,domaine) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, I.getNom());
            ps.setString(2, I.getPrenom());
            ps.setString(3, I.getMdp());
            ps.setString(4, I.getAdresse());
            ps.setInt(5, I.getTelephone());
            ps.setString(6, I.getEmail());
            ps.setString(7, I.getDomaine());



            ps.executeUpdate();
            System.out.println("Ajout presta effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion prestataire " + ex.getMessage());
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


public String affichnompresta(int idpresta) {

        String retour = "";


        String requete = "select nom,prenom from prestataire where id="+idpresta+";";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);

            ResultSet resultat = ps.executeQuery();
            if (resultat.next()) {
                retour = resultat.getString("prenom")+" "+resultat.getString("nom");


            }
            System.out.println(retour);
            return retour;



        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            retour = "no";
            return retour;
        }
    }


public String affichdompresta(int idpresta) {

        String retour = "";


        String requete = "select domaine from prestataire where id="+idpresta+";";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);

            ResultSet resultat = ps.executeQuery();
            if (resultat.next()) {
                retour = resultat.getString("domaine");


            }
            System.out.println(retour);
            return retour;



        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            retour = "no";
            return retour;
        }
    }





   





   



    


  


   

//////////////////////////////////////////////////



    ////////////////////////////////////////////////






     public List<Prestataire> getALLPrestataire(){

        List<Prestataire> prest = new ArrayList<Prestataire>();
        String requete = "Select * from prestataire ;";

        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Prestataire p = new Prestataire() ;
              //
                p.setNom(resultat.getString(1));
                p.setPrenom(resultat.getString(2));
                p.setPrix_serv(resultat.getDouble(3));
                p.setEmail(resultat.getString(4));
                p.setId(resultat.getInt(5));

                p.setTelephone(resultat.getInt(6));
                p.setAdresse(resultat.getString(7));
                p.setMdp(resultat.getString(8));

                p.setDomaine(resultat.getString(9));

            prest.add(p);
            }
            return prest ;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la selection prestataire " + ex.getMessage());
            return null;
        }

    }



    public List<String> getDistinctPrestataireDomaine(){

        List<String> domaines = new ArrayList<String>();
        String requete = "Select DISTINCT domaine from prestataire where domaine<>'Pensionnaire';";

        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                String p = "" ;
                p= resultat.getString("domaine");
                domaines.add(p);
            }
            return domaines ;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la selection " + ex.getMessage());
            return null;
        }
    }





    public List<Prestataire> getALLPrestataireByDomaine(String domaine){

        List<Prestataire> prest = new ArrayList<Prestataire>();
        String requete = "Select id,nom,prenom,adr,tel,prix_serv,email from prestataire where domaine='"+domaine+"';";

        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Prestataire p = new Prestataire() ;
                p.setId(resultat.getInt("id"));
                p.setNom(resultat.getString("nom"));
                p.setPrenom(resultat.getString("prenom"));
                p.setAdresse(resultat.getString("adr"));
                p.setTelephone(resultat.getInt("tel"));
                p.setPrix_serv(resultat.getDouble("prix_serv"));
                p.setEmail(resultat.getString("email"));
                System.out.println(resultat.getString("prenom"));
            prest.add(p);
            }
            return prest ;

        } catch (SQLException ex) {
            System.out.println("erreur getAllPrestataireByDomaine" + ex.getMessage());
            return null;
        }

    }



    public String getNamePrestataireByID(int id){


        String requete = "Select nom,prenom from prestataire where id = "+id+" ;";
        String nom = ""; String prenom="";
        try {
             PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
          nom =resultat.getString("nom");
          prenom = resultat.getString("prenom");
            }
            return nom+" "+prenom;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du NomPrestataire " + ex.getMessage());
            return "";
        }
    }


  public int getIDPrestataireByName(String nom){
        String[] split = nom.split("\\s+");
      System.out.println("FIRST "+split[0]+" LAST "+split[1]);
        String requete = "Select id from prestataire where nom = '"+split[0]+"' and prenom = '"+split[1]+"' ;";
        int id = 0;
        try {
             PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {

          id =resultat.getInt("id");
            }
            return id;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du ID Prestataire " + ex.getMessage());
            return 0;
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
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


public List<Prestataire> getAll() {
        String requete = "select * from prestataire";
        List<Prestataire> l = new ArrayList<Prestataire>();
        try {
            Statement s = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = s.executeQuery(requete);

            while (resultat.next()) {
                Prestataire p = new Prestataire();
                p.setId(resultat.getInt("id"));
                p.setNom(resultat.getString("nom"));
                p.setPrenom(resultat.getString("prenom"));
                p.setAdresse(resultat.getString("adr"));
                p.setDomaine(resultat.getString("domaine"));
                p.setJour_disp(resultat.getString("jour_disp"));
                p.setPrix_serv(resultat.getFloat("prix_serv"));
                p.setEmail(resultat.getString("email"));
                p.setTelephone(resultat.getInt("tel"));


                l.add(p);



            }
            return l;



        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur de recuperation de données " + ex.getMessage());
            return null;

        }

    }




public Prestataire getById(int id) {
        try {
            String query = "select * from prestataire where id=" + id;
            Statement s = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = s.executeQuery(query);
            Prestataire p = new Prestataire();
            while (resultat.next()) {

                p.setId(resultat.getInt("id"));
                p.setNom(resultat.getString("nom"));
                p.setPrenom(resultat.getString("prenom"));
                p.setAdresse(resultat.getString("adr"));
                p.setDomaine(resultat.getString("Domaine"));
                p.setJour_disp(resultat.getString("jour_disp"));
                p.setPrix_serv(resultat.getFloat("prix_serv"));
                p.setEmail(resultat.getString("email"));
                p.setTelephone(resultat.getInt("tel"));




            }
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }



public void delete(Prestataire t) {
        try {
            String query = "delete from prestataire where id=" + t.getId();
            Statement s = (Statement) MyConnection.getInstance().createStatement();
            s.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public void modifier(Prestataire t) {
        String requete = "update prestataire set nom=?, prenom=?, adr=?, domaine=?, jour_disp=? ,prix_serv=? , email=?, tel=? where id=?";
        try {
            PreparedStatement s = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);


            s.setString(1, t.getNom());
            s.setString(2, t.getPrenom());

            s.setString(3, t.getAdresse());

            s.setString(4, t.getDomaine());

            s.setString(5, t.getJour_disp());
            s.setFloat(6,(float) t.getPrix_serv());
            s.setString(7, t.getEmail());
            s.setInt(8, t.getTelephone());
            s.setInt(9, t.getId());



            s.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }


    }




}
