/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lss;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author user
 */
public class LSS implements WindowListener {

    static LSS lss;
    static UI ui;
    static Calculator calc;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }

        Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> {
            show_error(e);
        });
        lss = new LSS();
        ui = new UI();
        calc = new Calculator(ui);
        ui.addWindowListener(lss);

        try {
            File save = new File("./save");
            if (!save.exists()) {
                save.mkdir();
            }

            File f = new File("./loc.txt");
            if (f.exists()) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)))) {
                    int x = Integer.parseInt(reader.readLine());
                    int y = Integer.parseInt(reader.readLine());
                    ui.setLocation(x, y);

                    String path = reader.readLine();
                    if (path != null) {
                        ui.f_save_path = new File(path);
                    }
                }
            }
        } catch (IOException ex) {
        }

        try {
            ui.init();
        } catch (Exception ex) {
        }
        calc = new Calculator(ui);
    }

    static void show_error(Throwable e) {
        JOptionPane.showMessageDialog(ui, e.toString(), "エラーが発生しました", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            File f = new File("./loc.txt");
            if (f.exists()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
                    writer.write(Integer.toString(ui.getX()));
                    writer.newLine();
                    writer.write(Integer.toString(ui.getY()));
                    writer.newLine();
                    if (ui.file != null) {
                        writer.write(ui.file.getParent());
                    } else {
                        writer.write(ui.f_save_path.getPath());
                    }
                    writer.flush();
                }
            } else {
                f.createNewFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
                    writer.write(Integer.toString(ui.getX()));
                    writer.newLine();
                    writer.write(Integer.toString(ui.getY()));
                    writer.newLine();
                    if (ui.file != null) {
                        writer.write(ui.file.getParent());
                    } else {
                        writer.write(ui.f_save_path.getPath());
                    }
                    writer.flush();
                }
            }
        } catch (IOException ex) {
        }

        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
