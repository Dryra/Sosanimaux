/*
 * SOSView.java
 */
package sos;

import Dao.AdminDAO;
import Dao.DaoInt;
import Dao.PrestataireDAO;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserAdapter;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserNavigationEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.security.NoSuchAlgorithmException;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.StringReader;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import sos.RecupererInfoFacebook;

/**
 * The application's main frame.
 */
public class SOSView extends FrameView {
Thread someThread;
    public static int id;

    public static String API_KEY = "248569888637671";
public static String SECRET = "86f8de622e8036b1913f7434cc5b74d6";
    public static String firstRequest = "https://graph.facebook.com/oauth/authorize?"
            + "client_id="
            + API_KEY
            + "&redirect_uri=http://www.facebook.com/connect/login_success.html&"
            + "scope=publish_stream,offline_access,create_event,read_stream,email,user_birthday";
    public static String secondRequest = "https://graph.facebook.com/oauth/access_token?"
            + "client_id="
            + API_KEY
            + "&redirect_uri=http://www.facebook.com/connect/login_success.html&"
            + "client_secret=" + SECRET + "&code=";
    public static String access_token = "CAADiEqZCqAucBACDgkkMeNXAUZCgD2FSMvzpFYYQZB2AS5tyiVcO4ZC4L30sSqadU8J8nj98JFrx6C2kdjS96g7AEU2WTc3acQXkiMZBV0mcIPlFjk2CSZC1kAsIRkjWH2hKYM88gjwd75V2XqlIdQHoPAvQcCLo5POBPeEsGRTrvisp2uV0qt"
;
    public static boolean firstRequestDone = false;
    public static boolean secondRequestDone = false;

    public SOSView(SingleFrameApplication app) {









        super(app);

        initComponents();
Thread someThread;

        jButton1.setBackground(new Color(50, 89, 182));
        jButton1.setFocusPainted(false);

        jButton1.setFont(new Font("Tahoma", Font.BOLD, 12));

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = SOSApp.getApplication().getMainFrame();
            aboutBox = new SOSAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        SOSApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtlogin = new javax.swing.JTextField();
        btnConnexion = new javax.swing.JButton();
        pwdmp = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(sos.SOSApp.class).getContext().getResourceMap(SOSView.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        txtlogin.setText(resourceMap.getString("txtlogin.text")); // NOI18N
        txtlogin.setName("txtlogin"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(sos.SOSApp.class).getContext().getActionMap(SOSView.class, this);
        btnConnexion.setAction(actionMap.get("showEspaceAdmin")); // NOI18N
        btnConnexion.setText(resourceMap.getString("btnConnexion.text")); // NOI18N
        btnConnexion.setName("btnConnexion"); // NOI18N

        pwdmp.setText(resourceMap.getString("pwdmp.text")); // NOI18N
        pwdmp.setName("pwdmp"); // NOI18N

        jButton2.setAction(actionMap.get("fbevent")); // NOI18N
        jButton2.setBackground(resourceMap.getColor("jButton2.background")); // NOI18N
        jButton2.setIcon(resourceMap.getIcon("jButton2.icon")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtlogin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwdmp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(209, 209, 209))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pwdmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnConnexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        jButton1.setAction(actionMap.get("inscription")); // NOI18N
        jButton1.setFont(resourceMap.getFont("jButton1.font")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jButton3.setFont(resourceMap.getFont("jButton3.font")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(109, 109, 109)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusMessageLabel)
                            .addComponent(statusAnimationLabel)
                            .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        FacebookAuthentification fa = new FacebookAuthentification();
       fa.setVisible(true);
       


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      Motdepasseoublie mdpoubli = new Motdepasseoublie();
      mdpoubli.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    @Action
    public void showEspaceAdmin() {
        String rep = "";
        String rep2 = "";
        String rep3 = "";
        String encrypted=md5(pwdmp.getText().toString());
        rep = isadherant(txtlogin.getText(), encrypted);
        rep2 = isadmin(txtlogin.getText(), encrypted);
        rep3 = ispres(txtlogin.getText(),encrypted);
        

        PrestataireDAO preDAO = new PrestataireDAO();
        int idp = preDAO.findPrestaByLogin(txtlogin.getText(),encrypted);
        AdminDAO adminDAO = new AdminDAO();

        int idc = adminDAO.findAdmintByLogin(txtlogin.getText(),encrypted);

        DaoInt utilisateurDAO = new DaoInt();

        int ida = utilisateurDAO.findAddherant1ByLogin(txtlogin.getText(),encrypted);



        System.out.println(txtlogin.getText() + pwdmp.getText());
        if ((txtlogin.getText().isEmpty()) || (pwdmp.getText().isEmpty())) {
            JOptionPane.showMessageDialog(getComponent(), "Champs invalides \n" + "Vous devez saisir un login et un mot de passe valides");
        } else {

            if (rep.equals("existe")) {


                SOSEspaceAdherant espace_adherant = new SOSEspaceAdherant(ida);
                espace_adherant.setVisible(true);
                getFrame().dispose();

            } else if (rep2.equals("existe")) {
                SOSEspaceAdmin espace_admin = new SOSEspaceAdmin(idc);
               
                espace_admin.setVisible(true);

                getFrame().dispose();


            } else if (rep3.equals("existe")) {
                SOSEspacePrestataire espace_prestataire = new SOSEspacePrestataire(idp);

                espace_prestataire.setVisible(true);

                getFrame().dispose();


            } //            int idc = adminDAO.findAdmintByLogin(txtlogin.getText(), pwdmp.getText());
            //
            //            if (idc != -1) {
            //                SOSEspaceAdmin espace_admin = new SOSEspaceAdmin(idc);
            //                espace_admin.setVisible(true);
            //
            //                getFrame().dispose();
            //            } else  {
            //            DaoInt utilisateurDAO = new DaoInt();
            //                ida = utilisateurDAO.findAddherant1ByLogin(txtlogin.getText(), pwdmp.getText());
            //
            //                if ((ida != -1 )&&(ida !=0)) {
            //                    System.out.println(ida);
            //
            //                    SOSEspaceAdherant espace_adherant = new SOSEspaceAdherant(ida);
            //                    espace_adherant.setVisible(true);
            //                    getFrame().dispose();
            /*if (preDAO.findPrestaByLogin(txtlogin.getText(), pwdmp.getText()) == true) {
            espace_prest.setVisible(true);
            getFrame().dispose();*/ else {
                JOptionPane.showMessageDialog(getComponent(), "Login et/ou mot de passe invalide(s)");
            }

        }
    }

    @Action
    public void inscription() {
        Inscri inscri = new Inscri();
        inscriint inscripr = new inscriint();
        Object[] options = {"Je suis un utilisateur ", "Je suis un prestataire"};

        int n = JOptionPane.showOptionDialog(null,
                "Type d'inscription",
                "Qui étes vous ?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        if (n == 0) {
            inscripr.setVisible(true);
            
        }

        if (n == 1) {
            inscri.setVisible(true);
            
        }

    }

    public String isadmin(String login,String mdp) {
        String reponse = "";

        AdminDAO adminDAO = new AdminDAO();
        int idc = adminDAO.findAdmintByLogin(login,mdp);

        if ((idc != -1) && (idc != 0)) {

            reponse = "existe";

        }
        return reponse;
    }

    public String isadherant(String login, String mdp) {
        String reponse = "";
        DaoInt utilisateurDAO = new DaoInt();

        int ida = utilisateurDAO.findAddherant1ByLogin(login, mdp);

        if ((ida != -1) && (ida != 0)) {
            System.out.println(ida);


            reponse = "existe";
        }
        return reponse;
    }

    public String ispres(String login, String mdp) {

        String reponse = "";
        PrestataireDAO prestadao = new PrestataireDAO();

        int idp = prestadao.findPrestaByLogin(login, mdp);

        if ((idp != -1) && (idp != 0)) {
            System.out.println(idp);


            reponse = "existe";
        }
        return reponse;


    }

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
    private javax.swing.JButton btnConnexion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JPasswordField pwdmp;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTextField txtlogin;
    // End of variables declaration//GEN-END:variables
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private JDialog aboutBox;
}
