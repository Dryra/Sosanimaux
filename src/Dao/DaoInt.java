/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Animal;
import Entities.Prestataire;
import Entities.adherant;
import Util.MyConnection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.restfb.types.User;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Dryra
 */
public class DaoInt {

    public List<adherant> DisplayAllAdh() {


        List<adherant> listeadh = new ArrayList<adherant>();

        String requete = "select * from adherant";
        try {
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                adherant adherant = new adherant();
                adherant.setId(resultat.getInt(1));
                adherant.setNom(resultat.getString(2));
                adherant.setPrenom(resultat.getString(3));
                adherant.setEmail(resultat.getString(4));
                adherant.setMdp(resultat.getString(5));
                adherant.setVille(resultat.getString(6));
                adherant.setSexe(resultat.getString(10));

                listeadh.add(adherant);
                System.out.println(adherant);
            }
            return listeadh;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des adherants " + ex.getMessage());
            return null;
        }
    }

    public int findAdherantByLogin(String email, String mdp) {
        int i = 0;
        String requete = "select id from adherant where email=? and mdp=?";
        try {
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, email);
            ps.setString(2, mdp);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {

                System.out.println("login correct");

                i = resultat.getInt(1);
            }
            return i;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de l'adherant " + ex.getMessage());
            return -1;
        }
    }

    public int findAddherant1ByLogin(String email, String mdp) {

        String requete = "select * from adherant where email='" + email + "' and mdp='" + mdp + "'";
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
                i = resultat.getInt(1);
                System.out.println(resultat.getString(4));
                System.out.println(resultat.getString(5));
            } else {

                return -1;
            }
            return i;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(" erruer addherant " + ex.getMessage());
            return -1;
        }
    }

    public int getAdherantMasculin() {

        String requete = "select * from adherant where sexe='masculin';";
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
            System.out.println("erreur lors du chargement des adherants " + ex.getMessage());
            return -1;
        }
    }

    public int getAdherantFeminin() {

        String requete = "select * from adherant where sexe='feminin';";
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
            System.out.println("erreur lors du chargement des adherants " + ex.getMessage());
            return -1;
        }
    }

    public List<adherant> getAll(int idc) {
        String requete = "select * from adherant where id=?";
        List<adherant> l = new ArrayList<adherant>();
        try {
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);

            ps.setInt(1, idc);



            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                adherant p = new adherant();
                p.setNom(resultat.getString("nom"));
                p.setPrenom(resultat.getString("prenom"));
                p.setEmail(resultat.getString("email"));

                p.setVille(resultat.getString("ville"));
                p.setAge(resultat.getInt("age"));
                p.setTelephone(resultat.getInt("telephone"));


                l.add(p);



            }
            return l;



        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
            return null;

        }

    }

    public List<Animal> getAllanimal() {
        String requete = "select * from animal";
        List<Animal> ag = new ArrayList<Animal>();
        List<Animal> coul = new ArrayList<Animal>();
        try {
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);





            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                Animal a = new Animal();
                a.setId(resultat.getInt("id"));
                a.setAge(resultat.getString("age"));
                a.setCouleur(resultat.getString("couleur"));
                a.setEspece(resultat.getString("espece"));

                a.setEtat(resultat.getString("etat"));
                a.setPoids(resultat.getString("poids"));
                a.setRace(resultat.getString("race"));
                a.setSexe(resultat.getString("sexe"));
                a.setVaccin(resultat.getString("vaccin"));
                a.setAutre(resultat.getString("autre"));


                ag.add(a);





            }
            return ag;





        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
            return null;

        }

    }

    public List<Animal> getrech(List<String> l) {
        String requete = "select * from animal where etat=? and sexe=? and espece=? and age=? and race=? and poids=? and couleur=? and vaccin=?  ";
        List<Animal> ag = new ArrayList<Animal>();

        try {
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, (String) l.get(0));
            ps.setString(2, (String) l.get(1));
            ps.setString(3, (String) l.get(2));
            ps.setString(4, (String) l.get(3));
            ps.setString(5, (String) l.get(4));
            ps.setString(6, (String) l.get(5));
            ps.setString(7, (String) l.get(6));
            ps.setString(8, (String) l.get(7));





            ResultSet resultat = ps.executeQuery();

            while (resultat.next()) {
                Animal a = new Animal();
                a.setId(resultat.getInt("id"));
                a.setAge(resultat.getString("age"));
                a.setCouleur(resultat.getString("couleur"));
                a.setEspece(resultat.getString("espece"));
                a.setNom(resultat.getString("nom"));
                a.setEtat(resultat.getString("etat"));
                a.setPoids(resultat.getString("poids"));
                a.setRace(resultat.getString("race"));
                a.setSexe(resultat.getString("sexe"));
                a.setVaccin(resultat.getString("vaccin"));


                ag.add(a);





            }
            return ag;





        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
            return null;

        }

    }

    public String getmdp(String mdp) {
        adherant adher = new adherant();
        String retour = "";
        int checkmail = 0;

        String requete = "select count(*) from adherant where mdp=?";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, mdp);
            ResultSet resultat = ps.executeQuery();
            if (resultat.next()) {
                checkmail = resultat.getInt(1);
                if (checkmail > 0) {
                    retour = "yes";
                }

            }
            return retour;



        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            retour = "no";
            return retour;
        }
    }

    public String mail(String email) {
        adherant adher = new adherant();
        String retour = "";
        int checkmail = 0;
int checkmail2 = 0;
        String requete = "select count(*) from adherant where email=?";
        String requete2 = "select count(*) from prestataire where email=?";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            PreparedStatement ps2 = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete2);
            ps.setString(1, email);
            ps2.setString(1, email);
            ResultSet resultat = ps.executeQuery();
            ResultSet resultat2 = ps2.executeQuery();
            if (resultat.next() ) {
                checkmail = resultat.getInt(1);
                
                if (checkmail > 0) {
                    retour = "yes";
                }

            }
            else
            {
                if (resultat2.next() ) {
                checkmail = resultat2.getInt(1);

                if ( checkmail2 > 0) {
                    retour = "yes";
                }

            }
            }
            return retour;



        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur de verification email : " + ex.getMessage());
            retour = "no";
            return retour;
        }
    }

    public void updatead(List<String> l, int id) {

        String requete = "update adherant set nom=? , prenom=?, ville=?, age=?,telephone=? where id=?";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, l.get(0));
            ps.setString(2, l.get(1));
            ps.setString(3, l.get(2));
            ps.setInt(4, Integer.parseInt(l.get(3)));
            ps.setInt(5, Integer.parseInt(l.get(4)));

            ps.setInt(6, id);



            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

    public void insert(adherant I, File img) throws FileNotFoundException {

        String requete = "insert into adherant (nom,prenom,mdp,adresse,ville,email,sexe,photo,telephone,age) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, I.getNom());
            ps.setString(2, I.getPrenom());
            ps.setString(3, I.getMdp());
            ps.setString(4, I.getAdresse());
            ps.setString(5, I.getVille());
            ps.setString(6, I.getEmail());
            ps.setString(7, I.getSexe());
            FileInputStream fis = new FileInputStream(img);
            ps.setBinaryStream(8, fis, img.length());
            ps.setInt(9, I.getTelephone());
            ps.setInt(10, I.getAge());


            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès de inscription adhérant");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion adhérant " + ex.getMessage());
        }
    }


   



    public void insertanph(Animal A, File f) throws FileNotFoundException {

        String requete = "insert into animal (nom,espece,age,race,poids,couleur,vaccin,etat,autre,id_adh,photo,sexe,adr) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, A.getNom());
            ps.setString(2, A.getEspece());
            ps.setString(3, A.getAge());
            ps.setString(4, A.getRace());
            ps.setString(5, A.getPoids());
            ps.setString(6, A.getCouleur());
            ps.setString(7, A.getVaccin());
            ps.setString(8, A.getEtat());
            ps.setString(9, A.getAutre());
            ps.setInt(10, 3);
            FileInputStream fis = new FileInputStream(f);
            ps.setBinaryStream(11, fis, (int) f.length());
            ps.setString(12, A.getSexe());
ps.setString(13, "Tunis");


            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

    public void insertan(Animal A) {

        String requete = "insert into animal (nom,espece,age,race,poids,couleur,vaccin,etat,autre,id_adh,sexe,adr) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, A.getNom());
            ps.setString(2, A.getEspece());
            ps.setString(3, A.getAge());
            ps.setString(4, A.getRace());
            ps.setString(5, A.getPoids());
            ps.setString(6, A.getCouleur());
            ps.setString(7, A.getVaccin());
            ps.setString(8, A.getEtat());
            ps.setString(9, A.getAutre());
            ps.setInt(10, 3);
            //FileInputStream fis = new FileInputStream(f);
            //ps.setBinaryStream(12, fis, (int) f.length());
            ps.setString(11, A.getSexe());
 ps.setString(12, "Tunis");


            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

    public boolean findadherantbyEmail(String email) {

        String requete = "select * from adherant where email=?";
        try {
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, email);

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
            System.out.println("erreur lors de la recherche de l'adherant " + ex.getMessage());
            return false;
        }
    }

    public String checkmail(String email) {
        adherant adher = new adherant();
        String retour = "";
        int checkmail = 0;

        String requete = "select count(*) from adherant where email=?";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, email);
            ResultSet resultat = ps.executeQuery();
            if (resultat.next()) {
                checkmail = resultat.getInt(1);
                if (checkmail > 0) {
                    retour = "yes";
                }

            }
            return retour;



        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            retour = "no";
            return retour;
        }
    }

    public void insertadherantbyfacebook(List<String> l, File img) throws IOException {

        String requete = "insert into adherant (id,nom,prenom,email,ville,sexe,photo,mdp) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, l.get(0));
            ps.setString(2, l.get(1));
            ps.setString(3, l.get(2));
            ps.setString(4, l.get(3));
            ps.setString(5, l.get(4));
            ps.setString(6, l.get(5));
            ps.setString(8, l.get(6));

            //ByteArrayOutputStream os = new ByteArrayOutputStream();

            //ImageIO.write((RenderedImage) img, "jpg", os);
            //byte[] jpgByteArray = os.toByteArray();
            FileInputStream fis = new FileInputStream(img);
            ps.setBinaryStream(7, fis, img.length());





            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion de facebook " + ex.getMessage());
        }
    }


    public void insert(adherant t) {
        String requete = "insert into adherant (nom,prenom,email,mdp,telephone,adresse,ville,age,sexe) "
                + "values ('" + t.getNom() + "','" + t.getPrenom() + "','" + t.getEmail() +"','" +t.getMdp()+ "','" +t.getTelephone()+"','" +t.getAdresse() +"','"+t.getVille()+ "','"+ t.getAge()+ "','" + t.getSexe() + "')";

        try {
            Statement s = (Statement) MyConnection.getInstance().createStatement();
            s.execute(requete);
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }

    }




    public void modifier(adherant t) {

            String query = "update adherant set nom=?, prenom=?, telephone=? , adresse=?, ville=?  where id=?";
        try {
            PreparedStatement s = (PreparedStatement) MyConnection.getInstance().prepareStatement(query);

            s.setString(1, t.getNom());
            s.setString(2, t.getPrenom());
            s.setInt (3, t.getTelephone());
            s.setString(4, t.getAdresse());
            s.setString(5, t.getVille());
            s.setInt(6, t.getId());
            s.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }

}


    public adherant getById(int id) {
        try {
            String query = "select * from adherant where id=" + id;
            Statement s = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = s.executeQuery(query);
            adherant p = new adherant();
            while (resultat.next()) {

                p.setId(resultat.getInt("id"));
                p.setNom(resultat.getString("nom"));
                p.setPrenom(resultat.getString("prenom"));
                p.setEmail(resultat.getString("email"));
                p.setMdp(resultat.getString("mdp"));
                p.setTelephone(resultat.getInt("telephone"));
                p.setAdresse(resultat.getString("adresse"));
                p.setVille(resultat.getString("ville"));
                p.setAge(resultat.getInt("age"));
                p.setSexe(resultat.getString("sexe"));
            }
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public List<adherant> getAll() {
        String requete = "select * from adherant";
        List<adherant> l = new ArrayList<adherant>();
        try {
            Statement s = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = s.executeQuery(requete);

            while (resultat.next()) {
                adherant p = new adherant();
                p.setId(resultat.getInt("id"));
                p.setNom(resultat.getString("nom"));
                p.setPrenom(resultat.getString("prenom"));
                p.setEmail(resultat.getString("email"));
                p.setMdp(resultat.getString("mdp"));
                p.setTelephone(resultat.getInt("telephone"));
                p.setAdresse(resultat.getString("adresse"));
                p.setVille(resultat.getString("ville"));
                p.setAge(resultat.getInt("age"));
                p.setSexe(resultat.getString("sexe"));
                 l.add(p);
             }
            return l;



        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("methode getall de daoint " + ex.getMessage());
            return null;

        }

    }


    public void delete(adherant t) {
        try {
            String query = "delete from adherant where id=" + t.getId();
            Statement s = (Statement) MyConnection.getInstance().createStatement();
            s.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
}


    public String affichnomadh(int idadh) {
        adherant adher = new adherant();
        String retour = "";


        String requete = "select nom,prenom from adherant where id="+idadh+";";
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

public String retourpass(String email) {
String retour="";
        String requete = "select mdp from adherant where email='" + email + "' ";

        try {
            Statement statement = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

//            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
//            ps.setString(1, email);
//            ps.setString(2, mdp);
//            ResultSet resultat = ps.executeQuery();
            if (resultat.next() == true) {

                retour = resultat.getString("mdp");

            } else {

                return null;
            }
            return retour;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(" erruer addherant " + ex.getMessage());
            return null;
        }
    }

public void modifierpass(String pass,String email) {

            String query = "update adherant set mdp=?  where email=?" ;
        try {
            PreparedStatement s = (PreparedStatement) MyConnection.getInstance().prepareStatement(query);

            s.setString(1, pass);
            s.setString(2, email);

            s.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour mot de passe " + ex.getMessage());
        }

}





}