
package sos;


import Dao.DaoInt;

import Entities.adherant;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author slim
 */
public class ModifierUser extends javax.swing.JFrame {

    /**
     * Creates new form ModifierPrestataire
     */
    public ModifierUser() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
         Txtnom1.setText(SOSEspaceAdmin.usr.getNom());
            Txtprenom1.setText(SOSEspaceAdmin.usr.getPrenom());
            txtadr1.setText(SOSEspaceAdmin.usr.getAdresse());
            txttel1.setText(""+SOSEspaceAdmin.usr.getTelephone());
            txtville1.setText(SOSEspaceAdmin.usr.getVille());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabelname = new javax.swing.JLabel();
        jLabelnom = new javax.swing.JLabel();
        Txtprenom1 = new javax.swing.JTextField();
        Txtnom1 = new javax.swing.JTextField();
        jLabeladr = new javax.swing.JLabel();
        jLabeltel = new javax.swing.JLabel();
        txtadr1 = new javax.swing.JTextField();
        txttel1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtville1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SOS Animaux - Modification Adhérant");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jLabel1.setText("Modifier Adherant");

        jLabelname.setText("Prenom : *");

        jLabelnom.setText("Nom : *");

        Txtnom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txtnom1ActionPerformed(evt);
            }
        });

        jLabeladr.setText("Adresse : *");

        jLabeltel.setText("tel : *");

        txttel1.setToolTipText("");

        jButton1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Ville : *");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabeladr)
                                    .addComponent(jLabeltel))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtville1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(txtadr1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                    .addComponent(jButton1)
                                    .addComponent(txttel1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelname)
                                    .addComponent(jLabelnom, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Txtprenom1)
                                    .addComponent(Txtnom1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))))
                        .addGap(64, 64, 64)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelnom)
                    .addComponent(Txtnom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txtprenom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeltel))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabeladr)
                    .addComponent(txtadr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtville1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           
        if (Txtnom1.getText().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir le nom de l utilisateur");
        } else if (Txtprenom1.getText().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir le Prenom de l utilisateur");
        
        } else if (txttel1.getText().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir le telephone de l utilisateur");
        } else if (txtadr1.getText().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir l adresse de l utilisateur");
        } else if (txtville1.getText().equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir la ville de l utilisateur");
        }
            adherant u = new adherant();
            DaoInt d = new DaoInt();
          
          
            u.setId(SOSEspaceAdmin.usr.getId());
            u.setNom(Txtnom1.getText());
            u.setPrenom(Txtprenom1.getText());
            u.setAdresse(txtadr1.getText());
            u.setTelephone(Integer.parseInt(txttel1.getText()));
            //u.setAgeUser(SOSEspaceAdmin.usr.getAgeUser());
            //u.setSexeUser(SOSEspaceAdmin.usr.getSexeUser());
            //u.setAgeUser(SOSEspaceAdmin.usr.getAgeUser());
            //u.setMpUser(SOSEspaceAdmin.usr.getMpUser());
            u.setVille(txtville1.getText());
          
             d.modifier(u);
             setVisible(false);
            
            System.out.println("modif effectue");
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Modification Effectuée avec succés");

        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void Txtnom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txtnom1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txtnom1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModifierUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifierUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifierUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifierUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierUser().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Txtnom1;
    private javax.swing.JTextField Txtprenom1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabeladr;
    private javax.swing.JLabel jLabelname;
    private javax.swing.JLabel jLabelnom;
    private javax.swing.JLabel jLabeltel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtadr1;
    private javax.swing.JTextField txttel1;
    private javax.swing.JTextField txtville1;
    // End of variables declaration//GEN-END:variables
}
