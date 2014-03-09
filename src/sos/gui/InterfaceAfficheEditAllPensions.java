

package sos.gui;

import Dao.Daopension;
import Dao.PrestataireDAO;
import Entities.Pension;
import Entities.Prestataire;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


/**
 *
 * @author Lenovo
 */
public class InterfaceAfficheEditAllPensions extends javax.swing.JFrame {

private static int tempValue=-1;


    /** Creates new form InterfaceAfficheEditAllPensions */
    public InterfaceAfficheEditAllPensions() {
        initComponents();
       List <Prestataire> listprest =new ArrayList<Prestataire>();
        PrestataireDAO pDAO = new PrestataireDAO();
        Prestataire p = new Prestataire();
        DefaultListModel model = new DefaultListModel();
        jList1.setModel(model);
        listprest= pDAO.getALLPrestataireByDomaine("pensionnaire");
        for (int i = 0; i < listprest.size(); i++) {
            String nom = listprest.get(i).getNom();
            String prenom= listprest.get(i).getPrenom();
            String ch= nom + " " + prenom ;
            model.addElement(ch);
            jList1.updateUI();
            System.out.println("item ajouté");
        }



    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel1FocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Liste des Pensions");

        jTable1.setModel(new sos.gui.TableModelAfficheEditAllPensions());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setText("Liste des pensionnaires disponibles:");

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jButton4.setText("Terminé");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton3)))
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addGap(97, 97, 97))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(46, 46, 46)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Ajout
        new interfaceAjoutPension().show();
}//GEN-LAST:event_jButton1ActionPerformed




    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Suppression d'un ou plusieurs éléments de la jtable
        Pension p = new Pension();

         boolean test= false;     //TESTER SI'IL Y A DES ELEMENTS COCHés
                for(int i=0;i<jTable1.getRowCount();i++)
                    {
                        Boolean a =(Boolean)jTable1.getValueAt(i, 5);
                        if(a)
                        { test=true;
                          break; }

                      }

      if(test) // s'il y a des éléments
       {
         int dialogButton = JOptionPane.YES_NO_OPTION;
         JOptionPane.showConfirmDialog (null, "Voulez vous supprimer toutes les pensions selectionnés?","Warning",dialogButton);  // confirmation ?

                if(dialogButton == JOptionPane.YES_OPTION){


                     Daopension pDAO = new Daopension();

                    int ids[]=new int[50];
                    int j=-1;

                    for(int i=0;i<jTable1.getRowCount();i++)
                    {
                        Boolean b =(Boolean)jTable1.getValueAt(i, 5);

                        if(b)
                        {  j++;
                           ids[j]=(int) pDAO.getIdFromName(jTable1.getValueAt(i, 0).toString()) ;
                        }

                    }

                    while(j!=-1)
                        {
                         pDAO.deletePension(ids[j]);
                            System.out.println("element supprimé "+j);
                            j--;
                        }
                   TableModelAfficheEditAllPensions  model = new TableModelAfficheEditAllPensions();
                    jTable1.setModel(model);
                    jTable1.getColumnModel().getColumn(0).setMinWidth(0);
                    jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
                }
       }
       else
       {
            int diag = JOptionPane.PLAIN_MESSAGE;
                JOptionPane.showConfirmDialog (null, "Aucun élément sélectionné !","Warning",diag);


       }



}//GEN-LAST:event_jButton3ActionPerformed

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
    }//GEN-LAST:event_jPanel1FocusGained

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
                TableModelAfficheEditAllPensions tb = new TableModelAfficheEditAllPensions();
                jTable1.setModel(tb);
                tb.fireTableDataChanged();

    }//GEN-LAST:event_formFocusGained

    private void jPanel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1FocusLost

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       this.dispose();
}//GEN-LAST:event_jButton4ActionPerformed

private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
   if(evt.getClickCount()==2)
   {
       System.out.println("TEMP "+tempValue);
    if(tempValue!=-1)
    {
        jTable1.setValueAt(jList1.getSelectedValue().toString(),tempValue, 4);

        TableModelAfficheEditAllPensions tb = new TableModelAfficheEditAllPensions();
                jTable1.setModel(tb);
                tb.fireTableDataChanged();


    }else
    {
          JOptionPane.showMessageDialog(null, "Selectionnez le Pensionnaire que vous désiriez affecter à la pension");
    }

   }


}//GEN-LAST:event_jList1MouseClicked

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

 TableModelAfficheEditAllPensions tb = new TableModelAfficheEditAllPensions();
                jTable1.setModel(tb);
                tb.fireTableDataChanged();


}//GEN-LAST:event_formWindowOpened

private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
    if(evt.getKeyCode()==10)
    {

 TableModelAfficheEditAllPensions tb = new TableModelAfficheEditAllPensions();
                jTable1.setModel(tb);
                tb.fireTableDataChanged();
        
    }


}//GEN-LAST:event_jTable1KeyPressed

private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    tempValue=jTable1.getSelectedRow();

    // TODO add your handling code here:
}//GEN-LAST:event_jTable1MouseClicked


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceAfficheEditAllPensions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
