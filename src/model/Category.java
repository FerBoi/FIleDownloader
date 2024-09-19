/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 *
 * @author Fernando GJ
 */
public class Category {
    private String name;
    private ImageIcon icon;
    private List<Program> programs = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }
    
    public Category(String name, ImageIcon icon) {
        this.name = name;
        this.icon = icon;
    }
    
    public Category(String name, ImageIcon icon, List<Program> programs) {
        this.name = name;
        this.icon = icon;
        this.programs = programs;
    }
    
    public boolean addProgram(Program program) {
        if(!this.programs.contains(program)) {
            this.programs.add(program);
            return true;
        }
        
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "Category{" + "name=" + name + ", icon=" + icon + ", PROGRAMS=" + programs + '}';
    }
    
} // end Category