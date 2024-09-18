/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import model.Category;
import model.Program;
import view.MainWindow;

/**
 *
 * @author Fernando GJ
 */
public class Controller {
    private Category[] programCategories;
    private final MainWindow VIEW;
    
    public Controller(MainWindow view) {
        this.VIEW = view;
    }
    
    public void initialStatus() {
        this.programCategories = new Category[]{new Category("Web Browsers", new ImageIcon(Controller.class.getResource("/src/icon_webBrowser.png"))),
            new Category("Compression", new ImageIcon(Controller.class.getResource("/src/icon_compression.png"))),
            new Category("Messaging", new ImageIcon(Controller.class.getResource("/src/icon_messaging.png"))),
            new Category("Gaming", new ImageIcon(Controller.class.getResource("/src/icon_gaming.png"))),
            new Category("Media", new ImageIcon(Controller.class.getResource("/src/icon_media.png"))),
            new Category("Programming", new ImageIcon(Controller.class.getResource("/src/icon_programming.png"))),};

        this.programCategories[2].addProgram(new Program("Discord", new ImageIcon(Controller.class.getResource("/src/icon_discord_noSelected.png")), 
                new ImageIcon(Controller.class.getResource("/src/icon_discord_selected.png")), null));

        this.VIEW.fillViewCategories(this.programCategories);
    }
    
    
    
    public List<Program> programCategory(String categoryName) {
        List<Program> programList = new ArrayList<>();
        
        for (Category programCategory : this.programCategories) {
            if(programCategory.equals(new Category(categoryName))) {
                programList = programCategory.getPROGRAMS();
                break;
            }
        }
        
        return programList;
    }
        
   
} // end Controller