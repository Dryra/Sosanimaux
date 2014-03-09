package sos ;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class FacebookClient extends JFrame {

    JButton login;
    JButton getPermissionsForApp;
    JButton getAccessToken;
    JButton retrieveInformations;

    public FacebookClient() {
        
        this.setTitle("Authentification avec Facebook");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(400, 250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        login = new JButton("Login");
        getPermissionsForApp = new JButton("Get permission for application");
        retrieveInformations = new JButton("Retrieve informationst");
        getAccessToken = new JButton("Get access token");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        panel.add(login);
        panel.add(getPermissionsForApp);
        panel.add(getAccessToken);
        panel.add(retrieveInformations);
        add(panel);
    }

    public void setLoginListener(ActionListener l) {
        login.addActionListener(l);
    }

    public void setgetPermissionsForAppListener(ActionListener l) {
        getPermissionsForApp.addActionListener(l);
    }

    public void setretrieveUserListener(ActionListener l) {
        retrieveInformations.addActionListener(l);
    }

    public void setgetAccessTokenListener(ActionListener l) {
        getAccessToken.addActionListener(l);
    }
}