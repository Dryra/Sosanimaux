/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ajoutanimal.java
 *
 * Created on Feb 23, 2014, 4:56:48 PM
 */

package sos;

import Dao.DaoInt;
import Entities.Animal;
import Util.MyConnection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;

/**
 *
 * @author Dryra
 */
public class ajoutanimal extends javax.swing.JFrame {
 
    /** Creates new form ajoutanimal */
    public ajoutanimal() {
        initComponents();

        


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextespece = new javax.swing.JTextField();
        jTextrace = new javax.swing.JTextField();
        jTextcouleur = new javax.swing.JTextField();
        jTextpoids = new javax.swing.JTextField();
        jTextage = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCombosexe = new javax.swing.JComboBox();
        jCombovaccin = new javax.swing.JComboBox();
        jComboetat = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(sos.SOSApp.class).getContext().getResourceMap(ajoutanimal.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jTextespece.setText(resourceMap.getString("jTextespece.text")); // NOI18N
        jTextespece.setName("jTextespece"); // NOI18N

        jTextrace.setText(resourceMap.getString("jTextrace.text")); // NOI18N
        jTextrace.setName("jTextrace"); // NOI18N

        jTextcouleur.setText(resourceMap.getString("jTextcouleur.text")); // NOI18N
        jTextcouleur.setName("jTextcouleur"); // NOI18N

        jTextpoids.setText(resourceMap.getString("jTextpoids.text")); // NOI18N
        jTextpoids.setName("jTextpoids"); // NOI18N

        jTextage.setText(resourceMap.getString("jTextage.text")); // NOI18N
        jTextage.setName("jTextage"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName("jTextArea1"); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        jCombosexe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        jCombosexe.setName("jCombosexe"); // NOI18N

        jCombovaccin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Oui", "Non" }));
        jCombovaccin.setName("jCombovaccin"); // NOI18N

        jComboetat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "perdu", "sans refuge", "sans foyer" }));
        jComboetat.setName("jComboetat"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(sos.SOSApp.class).getContext().getActionMap(ajoutanimal.class, this);
        jButton2.setAction(actionMap.get("ajout")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jButton2)
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCombosexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jCombovaccin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextcouleur, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(jTextage, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(jTextpoids, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(jTextespece, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(jComboetat, 0, 135, Short.MAX_VALUE)
                                .addComponent(jTextrace, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel10)
                            .addGap(99, 99, 99)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboetat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextespece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextrace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextcouleur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextpoids, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jCombovaccin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jCombosexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74)
                .addComponent(jButton2)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents




     


    



    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        


    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ajoutanimal().setVisible(true);
            }
        });
    }

    @Action
    public void ajout(ActionEvent e1,ActionEvent e) throws FileNotFoundException  {





        if (e1.getSource()==jButton2)
{
        String espece=jTextespece.getText() ;
        String nom=jTextField1.getText() ;
String race=jTextrace.getText() ;
String couleur=jTextcouleur.getText() ;
String poids=jTextpoids.getText() ;
String age=jTextage.getText() ;
String Etat =jComboetat.getSelectedItem().toString();
String vaccin =jCombovaccin.getSelectedItem().toString();
String Sexe =jCombosexe.getSelectedItem().toString();
String autre=jTextArea1.getText();


if (espece.equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez donnez l'espece");
        } else if (race.equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez donner la race ");
        } else if (couleur.equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez donner la couleur");
        } else if (poids.equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez donner le poids");
        }
else if (age.equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez donner l'age ");
        }

else if (autre.equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez donner des informations supplimentaire");
        }
else {

    

Animal an  = new Animal();
an.setEtat(Etat);
an.setRace(race);
an.setPoids(poids);
an.setAge(age);
an.setAutre(autre);
an.setEspece(espece);
an.setCouleur(couleur);
an.setSexe(Sexe);
an.setVaccin(vaccin);
an.setNom(nom);





   
//File sfn=self(e.getSource());

DaoInt d = new DaoInt();
                
                    
                    
                
            


            //String[] options = {"Button 1", "Button 2", "Button 3"};
            //JOptionPane.showMessageDialog(j, "Ajout effectuée avec succés ","Félicitations!",JOptionPane.PLAIN_MESSAGE);
            
         Object[] options = {"Oui", "Non"};

     int n = JOptionPane.showOptionDialog(null,
    "Voulez vous ajouter une photo ?",
    "Question",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[1]);



     if (n==0)
      {
          JFileChooser chooser = new JFileChooser();
chooser.setCurrentDirectory(new java.io.File(".jpg"));
chooser.setDialogTitle("Choisir une photo");
chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
chooser.setAcceptAllFileFilterUsed(true);

if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
  System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
  System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
   File   sf2=(File)chooser.getSelectedFile();


   d.insertanph(an,sf2);
   JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Ajout effectué avec succés ");


}









      }

      
     else
     {

     d.insertan(an);
     JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Ajout effectué avec succés");
     }

      

     




}}

    }



   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboetat;
    private javax.swing.JComboBox jCombosexe;
    private javax.swing.JComboBox jCombovaccin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextage;
    private javax.swing.JTextField jTextcouleur;
    private javax.swing.JTextField jTextespece;
    private javax.swing.JTextField jTextpoids;
    private javax.swing.JTextField jTextrace;
    // End of variables declaration//GEN-END:variables

     
    
    
}
