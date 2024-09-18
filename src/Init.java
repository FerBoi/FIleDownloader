/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import controller.Controller;
import view.MainWindow;

/**
 *
 * @author Fernando GJ
 */
public class Init {

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        Controller controller = new Controller(mainWindow);
        mainWindow.setController(controller);
        controller.initialStatus();
        
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);

    } // end main

} // end Init
