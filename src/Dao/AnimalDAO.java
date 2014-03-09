/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import Util.MyConnection;
import java.util.List;
import Entities.Animal;
import Entities.adherant;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Dryra
 */
public class AnimalDAO {

    public int getAnimalEtatPerdu() {

        String requete = "select * from animal where etat='Perdu';";
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

        String requete = "select * from animal where etat='Sans refuge';";
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


    public void MiseAjourAnimal(Animal a) {
        String requete = "update animal set nom=?,espece=?,age=?,race=?,poids=?,couleur=?,vaccin=?,etat=?,autre=? where id=? ;";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, a.getNom());
            ps.setString(2, a.getEspece());
            ps.setString(3, a.getAge());
            ps.setString(4, a.getRace());
            ps.setString(5, a.getPoids());
            ps.setString(6, a.getCouleur());
            ps.setString(7, a.getVaccin());
            ps.setString(8, a.getEtat());
            ps.setString(9, a.getAutre());

            ps.setInt(10, a.getId());
            ps.executeUpdate();
            System.out.println("Animal mis a jour");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erreur lors du chargement des animaux per" + ex.getMessage());
           // System.out.println("erreur lors de la mise a jour " + ex.getMessage());
        }
    }




     public void SupprimerAnimal(int id) {

        String requete = "delete from animal where id=? ";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance()
                    .prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    //cette méthode permet d'afficher la lsite des animaux perdu
    public List<Animal> AfficherAnimauxPerdu() throws SQLException {

        List<Animal> listeanimauxperdu = new ArrayList<Animal>();

        String requete = "select * from animal where etat='Perdu'";
        try {
            Statement statement = (Statement) MyConnection.getInstance()
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Animal animal = new Animal();
                animal.setId(resultat.getInt("id"));
                animal.setNom(resultat.getString("nom"));
                animal.setEspece(resultat.getString("espece"));
                animal.setAge(resultat.getString("age"));
                animal.setRace(resultat.getString("race"));
                animal.setSexe(resultat.getString("sexe") );//***************
                animal.setPoids(resultat.getString("poids"));
                animal.setCouleur(resultat.getString("couleur"));
                animal.setVaccin(resultat.getString("vaccin"));
                animal.setEtat(resultat.getString("etat"));
                animal.setAutre(resultat.getString("autre"));
                animal.setId_adh(resultat.getInt("id_adh"));
             //   animal.setId_ut(resultat.getString(10));


                listeanimauxperdu.add(animal);

            }
            return listeanimauxperdu;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des animaux perdu" + ex.getMessage());
            return null;
        }
    }



    // cette méthode permet de changer l'état d'un animal et son propriétaire
    public void ModifierEtatAnimal(int ida,int idan)
    {
         String requete = "update animal set etat='Adopte',id_adh=?   where id=? ";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance()
                    .prepareStatement(requete);
            ps.setInt(1, ida);
            ps.setInt(2, idan);
            ps.executeUpdate();
            System.out.println("Animal adopté");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'adoption " + ex.getMessage());
        }
    }

    public void ModifierEtatAnimalretrouve(int ida,int idan)
    {
         String requete = "update animal set etat='Retrouvée',id_adh=?   where id=? ";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance()
                    .prepareStatement(requete);
            ps.setInt(1, ida);
            ps.setInt(2, idan);
            ps.executeUpdate();
            System.out.println("Animal Retrouvée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de retrouver " + ex.getMessage());
        }
    }

    // cette méthode affiche les animaux avec un étét sans refuge
     public List<Animal> AfficherAnimauxSansRefuge() {

        List<Animal> listeanimauxsansrefuge = new ArrayList<Animal>();

        String requete = "select * from animal where etat='Sans refuge'";
        try {
            Statement statement = (Statement) MyConnection.getInstance()
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Animal animal = new Animal();
                animal.setId(resultat.getInt("id"));
                animal.setNom(resultat.getString("nom"));
                animal.setEspece(resultat.getString("espece"));
                animal.setAge(resultat.getString("age"));
                animal.setRace(resultat.getString("race"));
                animal.setSexe(resultat.getString("sexe") );//***************
                animal.setPoids(resultat.getString("poids"));
                animal.setCouleur(resultat.getString("couleur"));
                animal.setVaccin(resultat.getString("vaccin"));
                animal.setEtat(resultat.getString("etat"));
                animal.setAutre(resultat.getString("autre"));
                animal.setId_adh(resultat.getInt("id_adh"));
             //   animal.setId_ut(resultat.getString(10));


                listeanimauxsansrefuge.add(animal);

            }
            return listeanimauxsansrefuge;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erreur lors du chargement des animaux perdu" + ex.getMessage());

            //System.out.println("erreur lors du chargement des animaux perdu" + ex.getMessage());
            return null;
        }
    }

// cette méthode permet d'afficher tout les animaux
     public List<Animal> AfficherAnimaux() {

        List<Animal> listeanimaux = new ArrayList<Animal>();

        String requete = "select * from animal ";
        try {
            Statement statement = (Statement) MyConnection.getInstance()
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Animal animal = new Animal();
                adherant adh = new adherant();
                animal.setId(resultat.getInt("id"));
                animal.setEspece(resultat.getString("espece"));
                animal.setAge(resultat.getString("age"));
                animal.setRace(resultat.getString("race"));
                animal.setPoids(resultat.getString("poids"));
                animal.setCouleur(resultat.getString("couleur"));
                animal.setVaccin(resultat.getString("vaccin"));
                animal.setSexe(resultat.getString("sexe"));
                animal.setEtat(resultat.getString("etat"));
                animal.setNom(resultat.getString("nom"));
                animal.setAutre(resultat.getString("autre"));
             //   animal.setId_ut(resultat.getString(10));


                listeanimaux.add(animal);

            }
            return listeanimaux;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des animaux" + ex.getMessage());
            return null;
        }
    }
//////////////////////////////////////////////////////////////////:



      public void SupprimerAnimal(Animal a) {
 try {
             String query = "delete from animal where id="+a.getId()+";";
          Statement s = (Statement) MyConnection.getInstance().createStatement();
            s.execute(query);
            System.out.println("Suppression effectué avec succées");
        } catch (Exception e) {
            e.printStackTrace();
        }}


   
    public Animal getById(int id) {
        try {
            String query = "select * from animal where id=" + id;
            Statement s = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = s.executeQuery(query);
            Animal animal = new Animal();
            while (resultat.next()) {
                animal.setId(resultat.getInt(1));
                animal.setNom(resultat.getString(2));
                animal.setEspece(resultat.getString(3));
                animal.setAge(resultat.getString(4));
                animal.setRace(resultat.getString(5));
                animal.setSexe(resultat.getString(6) );//***************
                animal.setPoids(resultat.getString(7));
                animal.setCouleur(resultat.getString(8));
                animal.setVaccin(resultat.getString(9));
                animal.setEtat(resultat.getString(10));
                animal.setAutre(resultat.getString(11));
                animal.setId_adh(resultat.getInt(12));
            }
            return animal;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }}

    public void insertanph(Animal A,File f,int id_adh) throws FileNotFoundException, SQLException  {

        String requete = "insert into animal (nom,espece,age,race,poids,couleur,vaccin,etat,autre,id_adh,photo,sexe) values (?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setInt(10, id_adh);
            FileInputStream fis = new FileInputStream(f);
            ps.setBinaryStream(11, fis, (int) f.length());
            ps.setString(12, A.getSexe());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
    
     public List<Animal> AfficherAnimauxadopté() {

        List<Animal> listeanimauxadopté = new ArrayList<Animal>();

        String requete = "select * from animal where etat='Adopte'";
        try {
             Statement statement = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            Animal a = new Animal();
            while (resultat.next()) {
                Animal animal = new Animal();
                animal.setId(resultat.getInt("id"));
                animal.setNom(resultat.getString("nom"));
                animal.setEspece(resultat.getString("espece"));
                animal.setAge(resultat.getString("age"));
                animal.setRace(resultat.getString("race"));
                animal.setSexe(resultat.getString("sexe") );//***************
                animal.setPoids(resultat.getString("poids"));
                animal.setCouleur(resultat.getString("couleur"));
                animal.setVaccin(resultat.getString("vaccin"));
                animal.setEtat(resultat.getString("etat"));
                animal.setAutre(resultat.getString("autre"));
                animal.setId_adh(resultat.getInt("id_adh"));



                listeanimauxadopté.add(animal);

            }
            return listeanimauxadopté;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des animaux adoptés " + ex.getMessage());
            return null;
        }
    }
     public List<Animal> AfficherAnimauxSansFoyer() {

        List<Animal> listeanimauxsansf = new ArrayList<Animal>();

        String requete = "select * from animal where etat='Sans foyer';";
        try {
             Statement statement = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            Animal a = new Animal();
            while (resultat.next()) {
                Animal animal = new Animal();
               
                animal.setId(resultat.getInt("id"));
                animal.setNom(resultat.getString("nom"));
                animal.setEspece(resultat.getString("espece"));
                animal.setAge(resultat.getString("age"));
                animal.setRace(resultat.getString("race"));
                animal.setSexe(resultat.getString("sexe") );//***************
                animal.setPoids(resultat.getString("poids"));
                animal.setCouleur(resultat.getString("couleur"));
                animal.setVaccin(resultat.getString("vaccin"));
                animal.setEtat(resultat.getString("etat"));
                animal.setAutre(resultat.getString("autre"));
                animal.setId_adh(resultat.getInt("id_adh"));


                listeanimauxsansf.add(animal);

            }
            return listeanimauxsansf;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des animaux sans foyer " + ex.getMessage());
            return null;
        }
    }


     public List<Animal> AfficherAnimauxRetrouvee() {

        List<Animal> listeanimauxsansf = new ArrayList<Animal>();

        String requete = "select * from animal where etat='Retrouvée';";
        try {
             Statement statement = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            Animal a = new Animal();
            while (resultat.next()) {
                Animal animal = new Animal();

                animal.setId(resultat.getInt("id"));
                animal.setNom(resultat.getString("nom"));
                animal.setEspece(resultat.getString("espece"));
                animal.setAge(resultat.getString("age"));
                animal.setRace(resultat.getString("race"));
                animal.setSexe(resultat.getString("sexe") );//***************
                animal.setPoids(resultat.getString("poids"));
                animal.setCouleur(resultat.getString("couleur"));
                animal.setVaccin(resultat.getString("vaccin"));
                animal.setEtat(resultat.getString("etat"));
                animal.setAutre(resultat.getString("autre"));
                animal.setId_adh(resultat.getInt("id_adh"));


                listeanimauxsansf.add(animal);

            }
            return listeanimauxsansf;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des animaux sans foyer " + ex.getMessage());
            return null;
        }
    }
    
    public void insertan(Animal A) {

        String requete = "insert into animal (nom,espece,age,race,sexe,poids,couleur,vaccin,etat,autre,id_adh) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, A.getNom());
            ps.setString(2, A.getEspece());
            ps.setString(3, A.getAge());
            ps.setString(4, A.getRace());
             ps.setString(5, A.getSexe());
            ps.setString(6, A.getPoids());
            ps.setString(7, A.getCouleur());
            ps.setString(8, A.getVaccin());
            ps.setString(9, A.getEtat());
            ps.setString(10, A.getAutre());
            ps.setInt(11, 1);
            //FileInputStream fis = new FileInputStream(f);
            //ps.setBinaryStream(12, fis, (int) f.length());




            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
}


    public List<Animal> AfficherAnimauxByAdherant(int idadh) {

        List<Animal> listeanimauxbyadherant = new ArrayList<Animal>();

        String requete = "select * from animal where id_adh="+idadh+";";
        try {
             PreparedStatement ps = (PreparedStatement) MyConnection.getInstance().prepareStatement(requete);
          
             ResultSet resultat = ps.executeQuery(requete);
            Animal a = new Animal();
            while (resultat.next()) {
                Animal animal = new Animal();
                animal.setId(resultat.getInt("id"));
                animal.setNom(resultat.getString("nom"));
                animal.setEspece(resultat.getString("espece"));
                animal.setAge(resultat.getString("age"));
                animal.setRace(resultat.getString("race"));
                animal.setSexe(resultat.getString("sexe") );//***************
                animal.setPoids(resultat.getString("poids"));
                animal.setCouleur(resultat.getString("couleur"));
                animal.setVaccin(resultat.getString("vaccin"));
                animal.setEtat(resultat.getString("etat"));
                animal.setAutre(resultat.getString("autre"));
                animal.setId_adh(resultat.getInt("id_adh"));


                listeanimauxbyadherant.add(animal);

            }
            return listeanimauxbyadherant;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des animaux sans foyer " + ex.getMessage());
            return null;
        }
    }


    public List<Animal> Getall(String type, String etat) {
        String query = "select * from animal where espece='"+type+"' and  etat ='"+etat+"'";

        Animal animal = new Animal();
        List<Animal> listanimal = new ArrayList<Animal>();
        try {
            Statement s = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = s.executeQuery(query);
            while (resultat.next()) {
                animal.setId(resultat.getInt("id"));
                animal.setNom(resultat.getString("nom"));
                animal.setEspece(resultat.getString("espece"));
                animal.setAge(resultat.getString("age"));
                animal.setRace(resultat.getString("race"));
                animal.setPoids(resultat.getString("poids"));
                animal.setCouleur(resultat.getString("couleur"));
                animal.setVaccin(resultat.getString("vaccin"));
                animal.setEtat(resultat.getString("etat"));
                animal.setSexe(resultat.getString("sexe"));
                System.out.println(resultat.getString("sexe"));
                listanimal.add(animal);

            }
            return listanimal;

        } catch (Exception e) {
            e.printStackTrace();

        }





        return null;

    }

    public void insertanbygeo(Animal A, File f,String ville,int idadh) throws FileNotFoundException {

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
            ps.setInt(10, idadh);
            FileInputStream fis = new FileInputStream(f);
            ps.setBinaryStream(11, fis, (int) f.length());
            ps.setString(12, A.getSexe());
            ps.setString(13,ville);



            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

public List<Double> Getlatlong(int id) {
        String query = "select adresse.lat , adresse.lon,animal.adr from adresse,animal where adresse.ville=animal.adr and animal.id="+id+";";

        
        List<Double> listcord = new ArrayList<Double>();
        try {
            Statement s = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = s.executeQuery(query);
            while (resultat.next()) {


 
                listcord.add(resultat.getDouble("lat"));
                listcord.add(resultat.getDouble("lon"));

            }
            return listcord;

        } catch (Exception e) {
            e.printStackTrace();

        }





        return null;

    }

public String Getville(int id) {
        String query = "select animal.adr from adresse,animal where adresse.ville=animal.adr and animal.id="+id+";";

        String ville = "";

        try {
            Statement s = (Statement) MyConnection.getInstance().createStatement();
            ResultSet resultat = s.executeQuery(query);
            while (resultat.next()) {



                ville=resultat.getString("adr");

            }
            return ville;

        } catch (Exception e) {
            e.printStackTrace();

        }





        return null;

    }



}
