/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import com.formdev.flatlaf.FlatLightLaf;
import controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.MainWindow;

/**
 *
 * @author Fernando GJ
 */
public class Init {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MainWindow mainWindow = new MainWindow();
        Controller controller = new Controller(mainWindow);
        
        mainWindow.setController(controller);
        controller.uploadProgramData();
        
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);

    } // end main

} // end Init
