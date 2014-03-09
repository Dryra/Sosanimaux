/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SOSAnimauxEspaceAdmin.java
 *
 * Created on 14 févr. 2014, 13:17:12
 */

package sos;

import Dao.Daopension;
import Dao.PrestataireDAO;
import Entities.Pension;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class SOSEspacePrestataire extends javax.swing.JFrame {
public static int idp;
    /** Creates new form SOSAnimauxEspaceAdmin */
    public SOSEspacePrestataire( int idp) {
        SOSEspacePrestataire.idp=idp ;
        initComponents();
        nomprenomlabel.setText(affichnom(SOSEspacePrestataire.idp));
    affichpensions();
    jButton5.setVisible(false);

    

    ////////////////////

    

    //////////////////


    jpanelajoutpension.setVisible(false);

    this.setTitle("SOS Animaux - Espace Prestataire : "+affichnom(SOSEspacePrestataire.idp)+"");

    }


    private SOSEspacePrestataire() {
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

        tabbedpanpresta = new javax.swing.JTabbedPane();
        panelpension = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        pensiontable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jpanelajoutpension = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nompension = new javax.swing.JTextField();
        adressepens = new javax.swing.JTextField();
        telephonepens = new javax.swing.JTextField();
        prixpens = new javax.swing.JTextField();
        dispobox = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nomprenomlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(sos.SOSApp.class).getContext().getResourceMap(SOSEspacePrestataire.class);
        tabbedpanpresta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("tabbedpanpresta.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, resourceMap.getFont("tabbedpanpresta.border.titleFont"), resourceMap.getColor("tabbedpanpresta.border.titleColor"))); // NOI18N
        tabbedpanpresta.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedpanpresta.setToolTipText(resourceMap.getString("tabbedpanpresta.toolTipText")); // NOI18N
        tabbedpanpresta.setName("tabbedpanpresta"); // NOI18N

        panelpension.setBackground(resourceMap.getColor("panelpension.background")); // NOI18N
        panelpension.setName("panelpension"); // NOI18N

        jSeparator2.setName("jSeparator2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        pensiontable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        pensiontable.setName("pensiontable"); // NOI18N
        jScrollPane1.setViewportView(pensiontable);

        jButton1.setBackground(resourceMap.getColor("jButton1.background")); // NOI18N
        jButton1.setFont(resourceMap.getFont("jButton1.font")); // NOI18N
        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jpanelajoutpension.setBackground(resourceMap.getColor("jpanelajoutpension.background")); // NOI18N
        jpanelajoutpension.setName("jpanelajoutpension"); // NOI18N

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

        nompension.setText(resourceMap.getString("nompension.text")); // NOI18N
        nompension.setName("nompension"); // NOI18N

        adressepens.setText(resourceMap.getString("adressepens.text")); // NOI18N
        adressepens.setName("adressepens"); // NOI18N

        telephonepens.setText(resourceMap.getString("telephonepens.text")); // NOI18N
        telephonepens.setName("telephonepens"); // NOI18N

        prixpens.setText(resourceMap.getString("prixpens.text")); // NOI18N
        prixpens.setName("prixpens"); // NOI18N

        dispobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi" }));
        dispobox.setName("dispobox"); // NOI18N

        jButton2.setFont(resourceMap.getFont("jButton2.font")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelajoutpensionLayout = new javax.swing.GroupLayout(jpanelajoutpension);
        jpanelajoutpension.setLayout(jpanelajoutpensionLayout);
        jpanelajoutpensionLayout.setHorizontalGroup(
            jpanelajoutpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelajoutpensionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpanelajoutpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelajoutpensionLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dispobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelajoutpensionLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(adressepens, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                    .addGroup(jpanelajoutpensionLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(37, 37, 37)
                        .addComponent(nompension, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelajoutpensionLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(42, 42, 42)
                        .addComponent(prixpens, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                    .addGroup(jpanelajoutpensionLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telephonepens, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                .addGap(105, 105, 105))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelajoutpensionLayout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpanelajoutpensionLayout.setVerticalGroup(
            jpanelajoutpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelajoutpensionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelajoutpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nompension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelajoutpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(adressepens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelajoutpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(telephonepens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelajoutpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(prixpens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelajoutpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dispobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jButton4.setFont(resourceMap.getFont("jButton4.font")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(resourceMap.getFont("jButton5.font")); // NOI18N
        jButton5.setText(resourceMap.getString("jButton5.text")); // NOI18N
        jButton5.setName("jButton5"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelpensionLayout = new javax.swing.GroupLayout(panelpension);
        panelpension.setLayout(panelpensionLayout);
        panelpensionLayout.setHorizontalGroup(
            panelpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelpensionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelpensionLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelpensionLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addComponent(jpanelajoutpension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelpensionLayout.setVerticalGroup(
            panelpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelpensionLayout.createSequentialGroup()
                .addGroup(panelpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelpensionLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelpensionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelpensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton4)
                        .addComponent(jButton5))
                    .addGroup(panelpensionLayout.createSequentialGroup()
                        .addComponent(jpanelajoutpension, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        tabbedpanpresta.addTab(resourceMap.getString("panelpension.TabConstraints.tabTitle"), panelpension); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        nomprenomlabel.setFont(resourceMap.getFont("nomprenomlabel.font")); // NOI18N
        nomprenomlabel.setText(resourceMap.getString("nomprenomlabel.text")); // NOI18N
        nomprenomlabel.setName("nomprenomlabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedpanpresta, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(nomprenomlabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomprenomlabel))
                .addGap(18, 18, 18)
                .addComponent(tabbedpanpresta, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrestataireDAO pda= new PrestataireDAO();
        String reponse=pda.affichdompresta(SOSEspacePrestataire.idp);
        if (reponse.equals("Pensionnaire"))
        {
jpanelajoutpension.setVisible(true);





        }
        else
        {
        JOptionPane.showMessageDialog(null, "Vous n'etes pas un pensionnaire \n Vous ne pouvez pas ajouter une pension  ");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nom=nompension.getText() ;
String adresse=adressepens.getText() ;
String jour_dispo =dispobox.getSelectedItem().toString();


    

try {
  int telephone=Integer.parseInt(telephonepens.getText());
    double prix=Double.parseDouble(prixpens.getText()) ;
    // or Integer.parseInt(text), etc.
    // OK, valid number.
  







if (nom.equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir le nom");
        }  else if (adresse.equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir l'adresse");
        }
        else
        { Daopension dap = new Daopension();
          Pension pen = new Pension();
          

          pen.setNom(nom);
          pen.setAdresse(adresse);
          pen.setJour_disp(adresse);
          pen.setJour_disp(jour_dispo);
          pen.setTelephone(telephone);
          pen.setPrix_pens(prix);
                try {
                    dap.insertpension(pen, SOSEspacePrestataire.idp);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SOSEspacePrestataire.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(SOSEspacePrestataire.class.getName()).log(Level.SEVERE, null, ex);
                }

            System.out.println("Ajout Terminé");
            JOptionPane.showMessageDialog(null, "Pension "+nom+" ajoutée avec succés !");
            jpanelajoutpension.setVisible(false);
        }


} catch (NumberFormatException nfe) {
    // Not a number.
    JOptionPane.showMessageDialog(null, "Le champ Prix et Téléphone doivent etre numeériques");
  }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        Daopension d = new Daopension();

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Id");
        defaultTableModel.addColumn("Ajouté par");
        defaultTableModel.addColumn("Adresse");
        defaultTableModel.addColumn("Télephone");
        defaultTableModel.addColumn("Prix");
        defaultTableModel.addColumn("Date dispo");





        for (int i = 0; i < d.getpensionbyid(SOSEspacePrestataire.idp).size(); i++) {


            defaultTableModel.addRow(new Object[]{d.getpension().get(i).getId(), d.getpension().get(i).getNom_prest() + d.getpension().get(i).getPrenom_prest(), d.getpension().get(i).getAdresse(), d.getpension().get(i).getTelephone(), d.getpension().get(i).getPrix_pens(), d.getpension().get(i).getJour_disp()});
        }

        pensiontable.setModel(defaultTableModel);
jButton5.setVisible(true);
jButton4.setVisible(false);



    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      affichpensions();
      jButton5.setVisible(false);
      jButton4.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SOSEspacePrestataire().setVisible(true);
            }
        });
    }

    public String affichnom(int idpresta)
    { PrestataireDAO daa= new PrestataireDAO();
        String nomprenom=daa.affichnompresta(idpresta);
        return nomprenom;


    }

    public void affichpensions()
    {

        Daopension d = new Daopension();

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Id");
        defaultTableModel.addColumn("Ajouté par");
        defaultTableModel.addColumn("Adresse");
        defaultTableModel.addColumn("Télephone");
        defaultTableModel.addColumn("Prix");
        defaultTableModel.addColumn("Date dispo");





        for (int i = 0; i < d.getpension().size(); i++) {


            defaultTableModel.addRow(new Object[]{d.getpension().get(i).getId(), d.getpension().get(i).getNom_prest() + d.getpension().get(i).getPrenom_prest(), d.getpension().get(i).getAdresse(), d.getpension().get(i).getTelephone(), d.getpension().get(i).getPrix_pens(), d.getpension().get(i).getJour_disp()});
        }

        pensiontable.setModel(defaultTableModel);
pensiontable.setAutoCreateColumnsFromModel(false);



    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adressepens;
    private javax.swing.JComboBox dispobox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jpanelajoutpension;
    private javax.swing.JTextField nompension;
    private javax.swing.JLabel nomprenomlabel;
    private javax.swing.JPanel panelpension;
    private javax.swing.JTable pensiontable;
    private javax.swing.JTextField prixpens;
    private javax.swing.JTabbedPane tabbedpanpresta;
    private javax.swing.JTextField telephonepens;
    // End of variables declaration//GEN-END:variables

}
