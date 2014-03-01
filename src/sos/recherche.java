/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * recherche.java
 *
 * Created on Feb 26, 2014, 2:19:23 AM
 */

package sos;

import Dao.DaoInt;
import Entities.Animal;
import java.awt.event.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.application.Action;



/**
 *
 * @author Dryra
 */
public class recherche extends javax.swing.JFrame {
DaoInt da = new DaoInt() ;

    /** Creates new form recherche */
    public  recherche() {
        initComponents();


jTable1.setVisible(false);

    final JTextField textfield = (JTextField)     jComboBox1.getEditor().getEditorComponent();
         final JTextField textfield2 = (JTextField)     jComboBox2.getEditor().getEditorComponent();
         final JTextField textfield3 = (JTextField)     jComboBox3.getEditor().getEditorComponent();
         final JTextField textfield4 = (JTextField)     jComboBox4.getEditor().getEditorComponent();
         final JTextField textfield5 = (JTextField)     jComboBox5.getEditor().getEditorComponent();
         final JTextField textfield6 = (JTextField)     jComboBox6.getEditor().getEditorComponent();
         final JTextField textfield7 = (JTextField)     jComboBox7.getEditor().getEditorComponent();
         final JTextField textfield8 = (JTextField)     jComboBox8.getEditor().getEditorComponent();

          final List<String> filterArray= new ArrayList<String>();
          final List<String> filterArray2= new ArrayList<String>();
          final List<String> filterArray3= new ArrayList<String>();
          final List<String> filterArray4= new ArrayList<String>();
          final List<String> filterArray5= new ArrayList<String>();
          final List<String> filterArray6= new ArrayList<String>();
          final List<String> filterArray7= new ArrayList<String>();
          final List<String> filterArray8= new ArrayList<String>();

          jComboBox1.setEditable(true);
       jComboBox2.setEditable(true);
       jComboBox3.setEditable(true);
       jComboBox4.setEditable(true);
       jComboBox5.setEditable(true);
       jComboBox6.setEditable(true);
       jComboBox7.setEditable(true);
       jComboBox8.setEditable(true);



        




jButton1.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
jTable1.setVisible(true);
final List<String> coul = new ArrayList<String>();
coul.add(""+textfield.getText());
coul.add(""+textfield2.getText());
coul.add(""+textfield3.getText());
coul.add(""+textfield4.getText());
coul.add(""+textfield5.getText());
coul.add(""+textfield6.getText());
coul.add(""+textfield7.getText());
coul.add(""+textfield8.getText());

      System.out.println("hahahahah");
                  
  DaoInt d = new DaoInt();
        
DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        defaultTableModel.addColumn("Id");
        defaultTableModel.addColumn("Nom");
        defaultTableModel.addColumn("Espece");
        defaultTableModel.addColumn("Age");
        defaultTableModel.addColumn("Race");
        defaultTableModel.addColumn("Poid");
        defaultTableModel.addColumn("Couleur");
        defaultTableModel.addColumn("Vaccin");
        defaultTableModel.addColumn("Etat");
        defaultTableModel.addColumn("Sexe");

      

        for (int i=0;i<d.getrech(coul).size();i++) {

            
            defaultTableModel.addRow(new Object[]{d.getrech(coul).get(i).getId(),d.getrech(coul).get(i).getNom(),d.getrech(coul).get(i).getEspece(),d.getrech(coul).get(i).getAge(),d.getrech(coul).get(i).getRace(),d.getrech(coul).get(i).getPoids(),d.getrech(coul).get(i).getCouleur(),d.getrech(coul).get(i).getVaccin(),d.getrech(coul).get(i).getEtat(),d.getrech(coul).get(i).getSexe()});
        }
        jTable1.setModel(defaultTableModel);

  }
} );





         //etat
           for ( int i=0;i<da.getAllanimal().size();i++)
           {
           filterArray.add(da.getAllanimal().get(i).getEtat());

             }
          //sexe
          for ( int i=0;i<da.getAllanimal().size();i++)
           {
           filterArray2.add(da.getAllanimal().get(i).getSexe());
          }
          //espece
          for ( int i=0;i<da.getAllanimal().size();i++)
           {
           filterArray3.add(da.getAllanimal().get(i).getEspece());
          }
          //age
          for ( int i=0;i<da.getAllanimal().size();i++)
           {
           filterArray4.add(da.getAllanimal().get(i).getAge());
          }
          //race
          for ( int i=0;i<da.getAllanimal().size();i++)
           {
           filterArray5.add(da.getAllanimal().get(i).getRace());
          }
          //poids
          for ( int i=0;i<da.getAllanimal().size();i++)
           {
           filterArray6.add(da.getAllanimal().get(i).getPoids());
          }
          //couleur
          for ( int i=0;i<da.getAllanimal().size();i++)
           {
           filterArray7.add(da.getAllanimal().get(i).getCouleur());
          }
          //vaccin
          for ( int i=0;i<da.getAllanimal().size();i++)
           {
           filterArray8.add(da.getAllanimal().get(i).getVaccin());
          }




    key(jComboBox1,textfield,filterArray);
    key(jComboBox2,textfield2,filterArray2);
    key(jComboBox3,textfield3,filterArray3);
    key(jComboBox4,textfield4,filterArray4);
    key(jComboBox5,textfield5,filterArray5);
    key(jComboBox6,textfield6,filterArray6);
    key(jComboBox7,textfield7,filterArray7);
    key(jComboBox8,textfield8,filterArray8);
    
    }



public void key(final JComboBox combo,final JTextField txtf,final List arrai){
    txtf.addKeyListener(new KeyAdapter() {

            @Override
        public void keyReleased(KeyEvent ke) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    comboFilter(txtf.getText(),combo,arrai);
                }


            });
        }
    });
}
    public void comboFilter(String enteredText1,JComboBox combo,List arrai) {

    if (arrai.size() > 0 ) {
        combo.setModel(new DefaultComboBoxModel(arrai.toArray()));
        combo.setSelectedItem(enteredText1);

        combo.showPopup();

    }
    else {
        combo.hidePopup();
    }




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
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jComboBox7 = new javax.swing.JComboBox();
        jComboBox8 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        jComboBox1.setName("jComboBox1"); // NOI18N

        jComboBox2.setName("jComboBox2"); // NOI18N

        jComboBox3.setName("jComboBox3"); // NOI18N

        jComboBox4.setName("jComboBox4"); // NOI18N

        jComboBox5.setName("jComboBox5"); // NOI18N

        jComboBox6.setName("jComboBox6"); // NOI18N

        jComboBox7.setName("jComboBox7"); // NOI18N

        jComboBox8.setName("jComboBox8"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(sos.SOSApp.class).getContext().getActionMap(recherche.class, this);
        jButton1.setAction(actionMap.get("rech")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(sos.SOSApp.class).getContext().getResourceMap(recherche.class);
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setFont(resourceMap.getFont("jTable1.font")); // NOI18N
        jTable1.setForeground(resourceMap.getColor("jTable1.foreground")); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox4, 0, 163, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox3, 0, 163, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, 163, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, 163, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addComponent(jComboBox5, 0, 169, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jButton2)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(505, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.Alignment.LEADING, 0, 161, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addGap(226, 226, 226))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:




    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

int id=0;

          if (jTable1.getSelectedRow() != -1) {
            id = (Integer) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);}
          System.out.println(""+id);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new recherche().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    


}
