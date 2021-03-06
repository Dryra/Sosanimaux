/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AjoutanimalGeolocal.java
 *
 * Created on Mar 8, 2014, 8:38:42 PM
 */

package sos;

import Dao.AnimalDAO;
import Entities.Animal;
import Util.MyConnection;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

/**
 *
 * @author Dryra
 */
public class AjoutanimalGeolocal extends javax.swing.JFrame {
public static int ida ;
    /** Creates new form AjoutanimalGeolocal */
    public AjoutanimalGeolocal(int ida) {
        AjoutanimalGeolocal.ida=ida;
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("SOS Animaux - Ajouter un Animal");
    }

    private AjoutanimalGeolocal() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        txtage = new javax.swing.JTextField();
        txtrace = new javax.swing.JTextField();
        txtpoids = new javax.swing.JTextField();
        txtcouleur = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        mapAnimal = new org.openstreetmap.gui.jmapviewer.JMapViewer();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtVille = new javax.swing.JTextField();
        jtLat = new javax.swing.JTextField();
        jtLon = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        combovaccin = new javax.swing.JComboBox();
        comboespece = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        combosexe = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        autretxt = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(sos.SOSApp.class).getContext().getResourceMap(AjoutanimalGeolocal.class);
        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        txtnom.setName("txtnom"); // NOI18N

        txtage.setName("txtage"); // NOI18N

        txtrace.setAutoscrolls(false);
        txtrace.setName("txtrace"); // NOI18N

        txtpoids.setName("txtpoids"); // NOI18N

        txtcouleur.setAutoscrolls(false);
        txtcouleur.setName("txtcouleur"); // NOI18N

        jButton1.setBackground(resourceMap.getColor("jButton1.background")); // NOI18N
        jButton1.setFont(resourceMap.getFont("jButton1.font")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator1.setName("jSeparator1"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jSeparator2.setName("jSeparator2"); // NOI18N

        jInternalFrame1.setName("jInternalFrame1"); // NOI18N
        jInternalFrame1.setVisible(true);

        mapAnimal.setName("mapAnimal"); // NOI18N
        mapAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapAnimalMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        jtVille.setName("jtVille"); // NOI18N

        jtLat.setName("jtLat"); // NOI18N

        jtLon.setName("jtLon"); // NOI18N
        jtLon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtLonActionPerformed(evt);
            }
        });

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        combovaccin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Oui", "Non" }));
        combovaccin.setName("combovaccin"); // NOI18N

        comboespece.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chat", "Chien", "Serpent", "Oiseau", "Panda", "Cheval", "Mouton" }));
        comboespece.setName("comboespece"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        combosexe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        combosexe.setName("combosexe"); // NOI18N

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        autretxt.setColumns(20);
        autretxt.setRows(5);
        autretxt.setName("autretxt"); // NOI18N
        jScrollPane1.setViewportView(autretxt);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sans refuge", "Sans foyer", "Perdu" }));
        jComboBox1.setName("jComboBox1"); // NOI18N

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcouleur)
                                    .addComponent(combovaccin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtVille, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtLat, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtLon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(combosexe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtage, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                                    .addComponent(comboespece, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtpoids, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                                    .addComponent(txtrace, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))))
                                    .addComponent(jLabel6))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 550, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(408, 408, 408))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(754, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(337, 337, 337))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(comboespece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtrace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtpoids, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcouleur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jtVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jtLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(combovaccin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(combosexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2201, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 447, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 448, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (txtnom.getText().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir le nom de l animal");
        }  else if (txtage.getText().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir l age de l animal");
        } else if (txtrace.getText().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir la race de l animal");
        } else if (combosexe.getSelectedItem().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez selectionner le sexe de l animal");
        } else if (txtpoids.getText().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir le poids de l animal");
        } else if (txtcouleur.getText().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir la couleur de l'animal");
        } else if (combovaccin.getSelectedItem().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir l'etat de l'animal");
        } else if (jtVille.getText().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez Selectionner une ville sur la carte");
            } else if (jtLon.getText().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez Selectionner une ville sur la carte");
        } else if (jtLat.getText().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez Selectionner une ville sur la carte");

        } else {
            String Sexe=(String) combosexe.getSelectedItem();
            String Vaccin=(String)combovaccin.getSelectedItem();
            String Espece=(String)comboespece.getSelectedItem();
            String Etat=(String)jComboBox1.getSelectedItem();

String ville = jtVille.getText();
String Long= jtLon.getText();
String Lati = jtLat.getText();
            String age=txtage.getText();
            String poid=txtpoids.getText();
            Animal p = new Animal();
            p.setNom(txtnom.getText());
            p.setEspece(Espece);
            p.setAge(age);
            p.setRace(txtrace.getText());
            p.setSexe(Sexe);
            p.setPoids(poid);
            p.setCouleur(txtcouleur.getText());
             p.setVaccin(Vaccin);
            p.setEtat(Etat);
            p.setAutre(autretxt.getText());
            //insertion dans la base de donnée
            AnimalDAO an = new AnimalDAO();


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
                
                   
                        try {
                            an.insertanbygeo(p, sf2, ville, SOSEspaceAdherant.ida);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(AjoutanimalGeolocal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                
   JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Ajout effectué avec succés ");
            this.dispose();

}  }
 else
     {

     an.insertan(p);
     JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Ajout effectué avec succés");
            this.dispose();
     }}
}//GEN-LAST:event_jButton1ActionPerformed

    private void mapAnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapAnimalMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            String showInputDialog = null;
            showInputDialog = JOptionPane.showInputDialog("Entrer la ville :");
            if (showInputDialog != null) {
                mapAnimal.getHeight();
                MapMarkerDot tmp = new MapMarkerDot(showInputDialog, new Coordinate(mapAnimal.getPosition(evt.getPoint()).getLat(), mapAnimal.getPosition(evt.getPoint()).getLon()));
                //tmp.setColor(new Color(255,0,0));
                tmp.setBackColor(Color.BLUE);

                mapAnimal.addMapMarker(tmp);

                System.out.println(tmp.getName().toString());
                System.out.println(mapAnimal.getPosition(evt.getPoint()).getLat() + "------>" + mapAnimal.getPosition(evt.getPoint()).getLon());

                jtVille.setText(tmp.getName().toString());
                jtLat.setText(""+mapAnimal.getPosition(evt.getPoint()).getLat());
                jtLon.setText(""+mapAnimal.getPosition(evt.getPoint()).getLon());

                //Inserer les coordonner dans la base de donnes
                String requeteUp = "INSERT INTO `sosanimaux`.`adresse`(`ville`,`lat`,`lon`)VALUES('" + tmp.getName().toString() + "'," + mapAnimal.getPosition(evt.getPoint()).getLat() + "," + mapAnimal.getPosition(evt.getPoint()).getLon() + ");";
                try {
                    java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requeteUp);
                    ps.executeUpdate();
                    System.out.println("Ajout ville effectué avec succès");

                } catch (SQLException ex) {
                    //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("erreur lors de l'insertion de la ville " + ex.getMessage());
                }
            }
        }
}//GEN-LAST:event_mapAnimalMouseClicked

    private void jtLonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtLonActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jtLonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutanimalGeolocal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea autretxt;
    private javax.swing.JComboBox comboespece;
    private javax.swing.JComboBox combosexe;
    private javax.swing.JComboBox combovaccin;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jtLat;
    private javax.swing.JTextField jtLon;
    private javax.swing.JTextField jtVille;
    private org.openstreetmap.gui.jmapviewer.JMapViewer mapAnimal;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtcouleur;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtpoids;
    private javax.swing.JTextField txtrace;
    // End of variables declaration//GEN-END:variables

}
