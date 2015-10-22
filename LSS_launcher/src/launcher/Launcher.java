/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author user
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        Updater updater = new Updater();
        File auto = new File("./auto_update.txt");
        if (!auto.exists()) {
            launch();
        } else {
            updater.check_update();
            if (updater.update_app || updater.update_data) {
                updater.setLayout(null);
                updater.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                updater.addWindowListener(updater);
                updater.setTitle("LSS updater");
                updater.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 200, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 60);
                updater.setResizable(false);
                updater.init();
                updater.setVisible(true);
            } else {
                launch();
            }
        }
    }

    static void launch() {
        try {
            ProcessBuilder p = new ProcessBuilder("java", "-jar", "./dist/LSS.jar");
            p.start();
        } catch (IOException ex) {
            System.out.println("起動に失敗しました");
        }
        System.exit(0);
    }
}
