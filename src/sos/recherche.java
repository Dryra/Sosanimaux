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

import Dao.AnimalDAO;
import Dao.DaoInt;
import Entities.Animal;
import Util.MyConnection;
import com.mysql.jdbc.ResultSet;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
panelplus1.setVisible(false);

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
      if(!textfield.getText().equals("")||!textfield2.getText().equals("")||!textfield3.getText().equals("")||!textfield4.getText().equals("")||!textfield5.getText().equals("")||!textfield6.getText().equals("")||!textfield7.getText().equals(""))
      {
      
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


            jTable1.repaint();


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
        defaultTableModel.addColumn("Autre");

      

        for (int i=0;i<d.getrech(coul).size();i++) {

            
            defaultTableModel.addRow(new Object[]{d.getrech(coul).get(i).getId(),d.getrech(coul).get(i).getNom(),d.getrech(coul).get(i).getEspece(),d.getrech(coul).get(i).getAge(),d.getrech(coul).get(i).getRace(),d.getrech(coul).get(i).getPoids(),d.getrech(coul).get(i).getCouleur(),d.getrech(coul).get(i).getVaccin(),d.getrech(coul).get(i).getEtat(),d.getrech(coul).get(i).getSexe(),d.getrech(coul).get(i).getEtat(),d.getrech(coul).get(i).getAutre()});
        }
        jTable1.setModel(defaultTableModel);
        jTable1.setAutoCreateColumnsFromModel(false);

  }}
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

        panelrechercheavanc = new javax.swing.JPanel();
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
        panelplus1 = new javax.swing.JPanel();
        photoanimal1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        autreanimal1 = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(sos.SOSApp.class).getContext().getResourceMap(recherche.class);
        panelrechercheavanc.setBackground(resourceMap.getColor("panelrechercheavanc.background")); // NOI18N
        panelrechercheavanc.setName("panelrechercheavanc"); // NOI18N

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
        jButton1.setFont(resourceMap.getFont("jButton1.font")); // NOI18N
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

            },
            new String [] {

            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        jButton2.setFont(resourceMap.getFont("jButton2.font")); // NOI18N
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

        panelplus1.setBackground(resourceMap.getColor("panelplus1.background")); // NOI18N
        panelplus1.setName("panelplus1"); // NOI18N

        photoanimal1.setName("photoanimal1"); // NOI18N

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        autreanimal1.setColumns(20);
        autreanimal1.setRows(5);
        autreanimal1.setName("autreanimal1"); // NOI18N
        jScrollPane5.setViewportView(autreanimal1);

        jLabel26.setText(resourceMap.getString("jLabel26.text")); // NOI18N
        jLabel26.setName("jLabel26"); // NOI18N

        jLabel27.setText(resourceMap.getString("jLabel27.text")); // NOI18N
        jLabel27.setName("jLabel27"); // NOI18N

        javax.swing.GroupLayout panelplus1Layout = new javax.swing.GroupLayout(panelplus1);
        panelplus1.setLayout(panelplus1Layout);
        panelplus1Layout.setHorizontalGroup(
            panelplus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelplus1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel27)
                .addGap(29, 29, 29)
                .addComponent(photoanimal1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addGroup(panelplus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelplus1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(panelplus1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel26)
                        .addContainerGap())))
        );
        panelplus1Layout.setVerticalGroup(
            panelplus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelplus1Layout.createSequentialGroup()
                .addGroup(panelplus1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelplus1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(photoanimal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelplus1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelplus1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel27)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jButton3.setFont(resourceMap.getFont("jButton3.font")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(resourceMap.getFont("jButton4.font")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelrechercheavancLayout = new javax.swing.GroupLayout(panelrechercheavanc);
        panelrechercheavanc.setLayout(panelrechercheavancLayout);
        panelrechercheavancLayout.setHorizontalGroup(
            panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelrechercheavancLayout.createSequentialGroup()
                .addGroup(panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelrechercheavancLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelrechercheavancLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)))
                .addGroup(panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelrechercheavancLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2))
                    .addGroup(panelrechercheavancLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelrechercheavancLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel3))
                    .addGroup(panelrechercheavancLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelrechercheavancLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelrechercheavancLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel4)))
                .addGroup(panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelrechercheavancLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelrechercheavancLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelrechercheavancLayout.createSequentialGroup()
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelrechercheavancLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(36, 36, 36)))
                .addGroup(panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelrechercheavancLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8))
                    .addGroup(panelrechercheavancLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelrechercheavancLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelrechercheavancLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelrechercheavancLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(54, 54, 54)
                        .addComponent(jButton2)
                        .addGap(56, 56, 56)
                        .addComponent(jButton3)
                        .addGap(66, 66, 66)
                        .addComponent(jButton4)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelrechercheavancLayout.createSequentialGroup()
                        .addComponent(panelplus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))))
        );
        panelrechercheavancLayout.setVerticalGroup(
            panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelrechercheavancLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(panelplus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(panelrechercheavancLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelrechercheavanc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelrechercheavanc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:




    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

int row = jTable1.getSelectedRow();
String etatan =(String.valueOf(jTable1.getModel().getValueAt(row,8).toString()));
        if (row==-1) {
            JOptionPane.showMessageDialog(null, "Vous devez selectionner un animal");
        }
        else
        {
    if(etatan.equals("sans foyer"))
    {
        AnimalDAO andao = new AnimalDAO();
        int id_animal =(Integer.valueOf(jTable1.getModel().getValueAt(row,0).toString()));
        andao.ModifierEtatAnimal(SOSEspaceAdherant.ida, id_animal); // ajouter la variable qui récupére l'id de l'utilisateur lors de sa connexion
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        defaultTableModel.removeRow(jTable1.getSelectedRow());
        jTable1.setModel(defaultTableModel);
        jTable1.repaint();
    }
    else JOptionPane.showMessageDialog(null, "Cet animal n'est pas à adopter");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (jTable1.getSelectedRow() != -1) {
            panelplus1.setVisible(true);
            int id = (Integer) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
            String autre = (String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 10);
            
                afficherphotoanimalperdu(id);
            
            autreanimal1.setText(autre);



        } else {
            JFrame frame2 = new JFrame();
            JOptionPane.showMessageDialog(frame2, "Veuillez selectionnez une ligne", "SOS Animaux - Attention", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
int row = jTable1.getSelectedRow();
String etatan =(String.valueOf(jTable1.getModel().getValueAt(row,8).toString()));
        if (row==-1) {
            JOptionPane.showMessageDialog(null, "Vous devez selectionner un animal");
        }
        else
        {
    if(etatan.equals("Perdu"))
    {
        AnimalDAO andao = new AnimalDAO();
        int id_animal =(Integer.valueOf(jTable1.getModel().getValueAt(row,0).toString()));
        andao.ModifierEtatAnimalretrouve(SOSEspaceAdherant.ida, id_animal); // ajouter la variable qui récupére l'id de l'utilisateur lors de sa connexion
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        defaultTableModel.removeRow(jTable1.getSelectedRow());
        jTable1.setModel(defaultTableModel);
        jTable1.repaint();
    }
    else JOptionPane.showMessageDialog(null, "Cet animal n'est pas Perdu pour etre retrouvée");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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



    public void afficherphotoanimalperdu(int idanimal) 
    { String requete = "select photo from animal where id=?";
        try {
            byte[] Imagebytes ;
            Image image ;
            java.sql.PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1,idanimal);

            java.sql.ResultSet resultat =ps.executeQuery();
            while (resultat.next())
            {
            Imagebytes=resultat.getBytes(1);
            image=getToolkit().createImage(Imagebytes);


 Image img =
    image.getScaledInstance(photoanimal1.getWidth(), photoanimal1.getHeight(), image.SCALE_FAST);
 ImageIcon icon = new ImageIcon(img);

            photoanimal1.setIcon(icon);


            }


            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur Image "+ex.getMessage());
        }


    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea autreanimal1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelplus1;
    private javax.swing.JPanel panelrechercheavanc;
    private javax.swing.JLabel photoanimal1;
    // End of variables declaration//GEN-END:variables

    


}
