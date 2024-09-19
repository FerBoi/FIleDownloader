/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Program;
import view.MainWindow;

/**
 *
 * @author Fernando GJ
 */
public class Controller {
    private final List<Category> PROGRAM_CATEGORIES;
    private final MainWindow VIEW;
    
    public Controller(MainWindow view) {
        this.VIEW = view;
        this.PROGRAM_CATEGORIES = new ArrayList<>();
    }
    
    public void initialStatus() {
        for (Category programCategory : IncludeSoftware.baseCategories())
            this.PROGRAM_CATEGORIES.add(programCategory);
        
        this.VIEW.fillViewCategories(this.PROGRAM_CATEGORIES.stream().toArray(Category[]::new));
    }
    
    public List<Program> programCategory(String categoryName) {
        List<Program> programList = new ArrayList<>();
        
        for (Category programCategory : this.PROGRAM_CATEGORIES) {
            if(programCategory.equals(new Category(categoryName))) {
                programList = programCategory.getPrograms();
                break;
            }
        }
        
        return programList;
    }
        
   
} // end Controller