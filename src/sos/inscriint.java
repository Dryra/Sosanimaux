/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * inscriint.java
 *
 * Created on Feb 16, 2014, 6:26:05 PM
 */

package sos;

import Dao.DaoInt;

import Entities.adherant;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;

/**
 *
 * @author Dryra
 */
public class inscriint extends javax.swing.JFrame {

    /** Creates new form inscriint */
    public inscriint() {
        initComponents();
        jPanel2.setVisible(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("SOS Animaux - Inscription");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        agefield = new javax.swing.JTextField();
        telfield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(241, 104, 64));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setText("Nom :*");

        jLabel2.setText("Prenom :*");

        jLabel3.setText("Email :*");

        jLabel4.setText("Adresse :*");

        jLabel5.setText("Sexe :*");

        jLabel6.setText("Ville :*");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Homme");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Femme");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ariana ", "Béja ", "Ben Arous ", "Bizerte ", "Gabès ", "Gafsa ", "Jendouba ", "Kairouan ", "Kasserine ", "Kébili ", "La Manouba ", "Le Kef ", "Mahdia ", "Médenine ", "Monastir ", "Nabeul ", "Sfax ", "Sidi Bouzid ", "Siliana ", "Sousse ", "Tataouine ", "Tozeur ", "Tunis ", "Zaghouan " }));

        jButton1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Mot de passe :*");

        jLabel10.setText("Age :*");

        jLabel11.setText("Téléphone :*");

        agefield.setText(" ");

        telfield.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                                .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(16, 16, 16)
                                                    .addComponent(jRadioButton1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jRadioButton2))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(agefield))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(telfield))))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGap(128, 128, 128))
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(133, 133, 133)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jButton1)
                .addContainerGap(232, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(444, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(413, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(agefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(telfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 14));
        jLabel8.setForeground(new java.awt.Color(34, 57, 152));
        jLabel8.setText("Inscription Adhérant");

        jLabel9.setText("Les champs avec * sont nécessaires");

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(sos.SOSApp.class).getContext().getActionMap(inscriint.class, this);
        jButton3.setAction(actionMap.get("Connexion")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel9)
                        .addGap(43, 43, 43)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(30, 30, 30))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

DaoInt d = new DaoInt();
String verifmail="";
        String type="" ;
        if (jRadioButton1.isSelected())
        {type=jRadioButton1.getText();}

        if (jRadioButton2.isSelected())
        {type=jRadioButton2.getText();}

        String nom=jTextField1.getText() ;
String prenom=jTextField2.getText() ;
String mdp=jPasswordField1.getText() ;
String adresse=jTextField4.getText() ;
String email=jTextField3.getText() ;
String domaine =jComboBox1.getSelectedItem().toString();

verifmail=d.mail(email);
try {
  int telephone=Integer.parseInt(telfield.getText());
    int age=Integer.parseInt(agefield.getText()) ;

if (nom.equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir le nom");
        } else if (prenom.equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir le Prenom ");
        } else if (mdp.equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir le mot de passe");
        } else if (adresse.equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir l'adresse");
        }
else if (email.equals("")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "Veuillez saisir l'adresse email");
        }

else if (verifmail.equals("yes")) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j, "E-mail non Disponible");
        }


else {

File imgfile = new File("C:\\Users\\Dryra\\Desktop\\fbpicture.jpg");




adherant in  = new adherant();
in.setNom(nom);
in.setPrenom(prenom);
in.setMdp(md5(mdp));
in.setAdresse(adresse);
in.setVille(domaine);
in.setEmail(email);
in.setSexe(type);
in.setTelephone(telephone);
in.setAge(age);
            try {
                d.insert(in, imgfile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(inscriint.class.getName()).log(Level.SEVERE, null, ex);
            }



JOptionPane.showMessageDialog(this, "Inscription Effectué avec succés");
jPanel2.setVisible(true);
this.dispose();












}

} catch (NumberFormatException nfe) {
    // Not a number.
    JOptionPane.showMessageDialog(null, "Vérifiez SVP les champs Age et télephone");
  }





    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inscriint().setVisible(true);
            }
        });
    }

    @Action
    public void Connexion() {
     SOSApp sosapp = new SOSApp();
     

                this.dispose();



    }


//    public String MD5Crypt(char[] textField) throws NoSuchAlgorithmException {
//        String mdp = "";
//        try {
//            for (int i = 0; i < textField.length; i++) {
//                mdp = mdp + textField[i];
//            }
//            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//            messageDigest.reset();
//            messageDigest.update(mdp.getBytes());
//            byte[] digest = messageDigest.digest();
//            BigInteger bigInt = new BigInteger(1, digest);
//            String hashText = bigInt.toString(16);
//            while (hashText.length() < 32) {
//                hashText = "0" + hashText;
//            }
//            return hashText;
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(inscriint.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }

    public String md5(String pass)
    {
        String passwordToHash = pass;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);
        return generatedPassword ;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agefield;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField telfield;
    // End of variables declaration//GEN-END:variables

}
