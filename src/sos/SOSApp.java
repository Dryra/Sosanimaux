/*
 * SOSApp.java
 */

package sos;

import Util.Splash;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class SOSApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new SOSView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of SOSApp
     */
    public static SOSApp getApplication() {
        return Application.getInstance(SOSApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(final String[] args) throws InterruptedException {

        //Apparence de l'application
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (Exception e) {
            System.out.println("Nimbus isn't available");
        }

            Splash s = new Splash();
            s.setVisible(true);
            Thread t = Thread.currentThread();
            t.sleep(4000);
            s.dispose();
            SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    //opening the main application
                    launch(SOSApp.class, args);
                }
            });
        }
}
