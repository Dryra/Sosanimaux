/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FacturePension.java
 *
 * Created on 2 mars 2014, 14:27:30
 */
package sos;


import Dao.Daopension;
import Entities.Animal;
import Entities.Pension;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Header;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabStop.Alignment;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author slim
 */
public class FacturePension extends javax.swing.JFrame {

    Daopension dAOPension = new Daopension();

    /** Creates new form FacturePension */
    public FacturePension() {
        this.setTitle("SOS Animaux - Facture de Pension");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        
//        List<Pension> peList = new ArrayList<Pension>();
//        peList = dAOPension.getAll();
//        defaultTableModel.addColumn("id");
//        defaultTableModel.addColumn("Adresse");
//        defaultTableModel.addColumn("Telephone");
//        defaultTableModel.addColumn("Prix service");
//        defaultTableModel.addColumn("Jours Disponible");
//        //Chargement du tableau d es l ouverture de la page
//       for (int i = 0; i < dAOPension.getAll().size(); i++) {
//            defaultTableModel.addRow(new Object[]{dAOPension.getAll().get(i).getId(), dAOPension.getAll().get(i).getAdresse(), dAOPension.getAll().get(i).getTelephone(), dAOPension.getAll().get(i).getPrix_serv(), dAOPension.getAll().get(i).getJour_disp()});
//
//        }


        Daopension d = new Daopension();

        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        defaultTableModel.addColumn("Id");
        defaultTableModel.addColumn("Ajouté par");
        defaultTableModel.addColumn("Adresse");
        defaultTableModel.addColumn("Télephone");
        defaultTableModel.addColumn("Prix");
        defaultTableModel.addColumn("Date dispo");





        for (int i = 0; i < d.getpension().size(); i++) {


            defaultTableModel.addRow(new Object[]{d.getpension().get(i).getId(), d.getpension().get(i).getNom_prest() + d.getpension().get(i).getPrenom_prest(), d.getpension().get(i).getAdresse(), d.getpension().get(i).getTelephone(), d.getpension().get(i).getPrix_pens(), d.getpension().get(i).getJour_disp()});
        }
        
        jTable1.setModel(defaultTableModel);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(sos.SOSApp.class).getContext().getResourceMap(FacturePension.class);
        jButton1.setBackground(resourceMap.getColor("jButton1.background")); // NOI18N
        jButton1.setFont(resourceMap.getFont("jButton1.font")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jButton1)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Pension p = new Pension();
        p.setId(Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0))));
        String Nom=String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 1));
        p.setAdresse(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 2)));
        p.setTelephone(Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 3))));
        p.setPrix_pens(Float.valueOf(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 4))));
        
p.setJour_disp((String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 5));
        //creation de document pdf
Random generator = new Random();
int i = generator.nextInt(1000) + 1;
        try {
            File f = new File("c:/pidev");
            f.mkdirs();
            File f1 = new File("c:/pidev/facture"+p.getId()+".pdf");
            Document d = new Document();
            PdfWriter.getInstance(d, new FileOutputStream(f1));
            d.open();
            d.addCreator("Slim Saddem");
            Paragraph title = new Paragraph("Facture Pension", new Font(Font.FontFamily.TIMES_ROMAN, 32, Font.BOLDITALIC));
            title.setAlignment(Element.ALIGN_CENTER);
            d.add(title);
            d.add(new LineSeparator());
            d.addCreationDate();
            d.add(new Paragraph("\r\n\r\n\r\n\r\n"));
            Paragraph p1 = new Paragraph("Adresse Pension : " + p.getAdresse() + "\r\n");
            d.add(p1);

            d.add(new Phrase("Numéro de téléphone : " + p.getTelephone() + "\r\n"));
            d.add(new Phrase("Prix du service :" + p.getPrix_pens() + "\r\n"));
            d.add(new Phrase("jours disponibiles :" + p.getJour_disp() + "\r\n"));
            d.add(new Phrase("Nom Pensionnaire :" + Nom + "\r\n"));
            d.close();
            Runtime r = Runtime.getRuntime();
            //Pour afficher le fichier PDf Des l execution
            r.exec(new String[]{"C:/Program Files (x86)/Adobe/Reader 9.0/Reader/AcroRd32.exe", "c:/pidev/facture"+p.getId()+".pdf"});
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FacturePension().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}