package sos;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;
import com.restfb.*;
import com.restfb.types.*;
import com.restfb.util.*;

public class FacebookTestClient extends JFrame {

 JButton login;
 JButton getPermissionsForApp;
 JButton retrieveUser;
 JButton getAccessToken;

 public FacebookTestClient() {
  login = new JButton("Login");
  getPermissionsForApp = new JButton("Obtenir la permission");
  retrieveUser = new JButton("Se connecter avec mon compte Facebook");
  getAccessToken = new JButton("get access_token");

  JPanel panel = new JPanel();
  panel.setLayout(new GridLayout(0, 1));

  panel.add(login);
  panel.add(getPermissionsForApp);
  panel.add(retrieveUser);
  panel.add(getAccessToken);

  add(panel);

  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setSize(100, 125);
  setLocationRelativeTo(null);
  setVisible(true);
  // VOIR MEANING
  pack();
 }

 public void setLoginListener(ActionListener l) {
  login.addActionListener(l);
 }

 public void setgetPermissionsForAppListener(ActionListener l) {
  getPermissionsForApp.addActionListener(l);
 }

 public void setretrieveUserListener(ActionListener l) {
  retrieveUser.addActionListener(l);
 }

 public void setgetAccessTokenListener(ActionListener l) {
  getAccessToken.addActionListener(l);
 }

}
