/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package view;

import controller.Controller;
import controller.Downloader;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import model.Category;
import model.Program;

/**
 *
 * @author Fernando GJ
 */
public class MainWindow extends javax.swing.JFrame implements MouseListener {
    private Controller controller;
    private final List<Program> TO_DOWNLOAD;
    private final DefaultListModel<String> LIST_MODEL;
    
    private final JPopupMenu POP_UP_MENU;

    /** Creates new form MainWindow */
    public MainWindow() {
        initComponents();
        
        this.TO_DOWNLOAD = new ArrayList<>();
        this.LIST_MODEL = new DefaultListModel<>();
        this.POP_UP_MENU = new JPopupMenu();
        this.programList.setModel(this.LIST_MODEL);
         
        
        this.preparePopUp();
        this.prepareIcons();
        this.prepareMouseListener();
    }
    
    private void preparePopUp() {
        JMenuItem optionOne = new JMenuItem("Delete");
        JMenuItem optionTwo = new JMenuItem("Delete All");
        
        this.POP_UP_MENU.add(optionOne);
        this.POP_UP_MENU.add(optionTwo);

        optionOne.addActionListener((e) -> {
            int index = this.programList.getSelectedIndex();

            if (index != -1) {
                this.LIST_MODEL.removeElementAt(index);
                this.TO_DOWNLOAD.remove(index);

                if (this.TO_DOWNLOAD.isEmpty()) {
                    this.panelRefresh(this.chanchingPanel, this.gridLayout);
                    this.changePanel(this.chanchingPanel);
                }
            } else {
                JOptionPane.showConfirmDialog(this, "Select a list item to remove", "ERROR",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        });

        optionTwo.addActionListener((e) -> {
            this.LIST_MODEL.removeAllElements();
            this.TO_DOWNLOAD.removeAll(this.TO_DOWNLOAD);
            this.panelRefresh(this.chanchingPanel, this.gridLayout);
            this.changePanel(this.chanchingPanel);
        });
    }
    
    private void prepareIcons() {
        this.setIconImage(new ImageIcon(MainWindow.class.getResource("/src/window_icon.png")).getImage());
        this.returnBtm.setIcon(new ImageIcon(MainWindow.class.getResource("/src/back_arrow.png")));
        this.downloadListBtn.setIcon(new ImageIcon(MainWindow.class.getResource("/src/icon_download.png")));
        this.deleteListBtn.setIcon(new ImageIcon(MainWindow.class.getResource("/src/icon_delete.png")));
    }
    
    private void prepareMouseListener() {
        this.downloadListBtn.addMouseListener(this);
        this.deleteListBtn.addMouseListener(this);
        this.myList.addMouseListener(this);
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chanchingPanel = new javax.swing.JPanel();
        gridLayout = new javax.swing.JPanel();
        secundaryPanel = new javax.swing.JPanel();
        backPanel = new javax.swing.JPanel();
        returnBtm = new javax.swing.JButton();
        insideChancingPanel = new javax.swing.JPanel();
        optionPanel = new javax.swing.JPanel();
        listPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        programList = new javax.swing.JList<>();
        downloadListBtn = new javax.swing.JButton();
        deleteListBtn = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        myList = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Helper to Start");
        setResizable(false);

        chanchingPanel.setLayout(new java.awt.CardLayout());

        gridLayout.setLayout(new java.awt.GridLayout(0, 3, 20, 0));
        chanchingPanel.add(gridLayout, "card2");

        secundaryPanel.setLayout(new javax.swing.BoxLayout(secundaryPanel, javax.swing.BoxLayout.Y_AXIS));

        returnBtm.setBorder(null);
        returnBtm.setContentAreaFilled(false);
        returnBtm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backPanelLayout = new javax.swing.GroupLayout(backPanel);
        backPanel.setLayout(backPanelLayout);
        backPanelLayout.setHorizontalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(returnBtm)
                .addContainerGap(501, Short.MAX_VALUE))
        );
        backPanelLayout.setVerticalGroup(
            backPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(returnBtm)
                .addContainerGap())
        );

        secundaryPanel.add(backPanel);

        insideChancingPanel.setLayout(new java.awt.CardLayout());

        optionPanel.setLayout(new java.awt.GridLayout(0, 3));
        insideChancingPanel.add(optionPanel, "card2");

        listPanel.setLayout(new javax.swing.BoxLayout(listPanel, javax.swing.BoxLayout.LINE_AXIS));

        programList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        programList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        programList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        programList.setPreferredSize(new java.awt.Dimension(20, 90));
        scrollPane.setViewportView(programList);

        listPanel.add(scrollPane);

        downloadListBtn.setToolTipText("Download list");
        downloadListBtn.setBorderPainted(false);
        downloadListBtn.setContentAreaFilled(false);
        downloadListBtn.setMargin(new java.awt.Insets(2, 14, 3, 20));
        listPanel.add(downloadListBtn);

        deleteListBtn.setToolTipText("Delete selected element from list");
        deleteListBtn.setBorderPainted(false);
        deleteListBtn.setContentAreaFilled(false);
        deleteListBtn.setMargin(new java.awt.Insets(2, 14, 3, 20));
        listPanel.add(deleteListBtn);

        insideChancingPanel.add(listPanel, "card3");

        secundaryPanel.add(insideChancingPanel);

        chanchingPanel.add(secundaryPanel, "card3");

        myList.setText("My List");
        menuBar.add(myList);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chanchingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chanchingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnBtmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtmActionPerformed
        this.panelRefresh(this.chanchingPanel, this.gridLayout);
        this.changePanel(this.chanchingPanel);
    }//GEN-LAST:event_returnBtmActionPerformed

    public void fillViewCategories(Category[] programCategories) {
        for (Category programCategory : programCategories) {
            JLabel label = new JLabel(programCategory.getIcon());
            label.setToolTipText(programCategory.getName());
            label.setOpaque(true);
            label.addMouseListener(this);
            this.gridLayout.add(label);
        }
    }
    
    private void panelRefresh(JPanel panelToRefresh, JPanel newPanel) {
        panelToRefresh.removeAll();
        panelToRefresh.add(newPanel);
    }
    
    private void changePanel(JPanel panelToRepaint) {
        panelToRepaint.revalidate();
        panelToRepaint.repaint();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JLabel label) {
            List<Program> categoryPrograms = this.controller.programCategory(label.getToolTipText());
            
            if (!categoryPrograms.isEmpty()) {
                this.insideChancingPanel.removeAll();
                this.optionPanel.removeAll();
                
                label.setBackground(this.getBackground());

                for (Program program : categoryPrograms) {
                    JCheckBox checkBox = new JCheckBox(program.getName());

                    if (this.TO_DOWNLOAD.contains(program))
                        checkBox.setSelected(true);

                    checkBox.addActionListener((ae) -> {
                        if (checkBox.isSelected()) {
                            this.TO_DOWNLOAD.add(program);
                        } else {
                            this.TO_DOWNLOAD.remove(program);
                        }
                    });

                    this.optionPanel.add(checkBox);
                }

                this.panelRefresh(this.chanchingPanel, this.secundaryPanel);
                this.changePanel(this.chanchingPanel);

                this.panelRefresh(this.insideChancingPanel, this.optionPanel);
                this.changePanel(this.insideChancingPanel);
            } else
                JOptionPane.showConfirmDialog(this, "No programs in this category", "ERROR", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        } else if(e.getSource() instanceof JMenu) {
            this.insideChancingPanel.removeAll();
            
            if(!this.TO_DOWNLOAD.isEmpty()) {
                this.LIST_MODEL.clear();
                
                for (Program program : this.TO_DOWNLOAD)
                    this.LIST_MODEL.addElement(program.getName());
                
                this.panelRefresh(this.chanchingPanel, this.secundaryPanel);
                this.changePanel(this.chanchingPanel);

                this.panelRefresh(this.insideChancingPanel, this.listPanel);
                this.changePanel(this.insideChancingPanel);
            } else 
                JOptionPane.showConfirmDialog(this, "Any program in your list", "ERROR", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        } else {           
            JButton btnPressed = (JButton) e.getSource();
            
            if(btnPressed == this.downloadListBtn) {
                JFileChooser fc = new JFileChooser(new File(".")); // jc will open in current directory
                fc.setDialogTitle("Directory to save");
                
                // FileChooser conf for saving
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.setApproveButtonText("Save");
                fc.setAcceptAllFileFilterUsed(false);
         
                int result = fc.showOpenDialog(this);
                
                if(result == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    
                    if(!file.exists())
                        file.mkdir();
                    
                    DownloaderStatus progressDialog = new DownloaderStatus(this, true);
                    Downloader.viewDownloadStatus = progressDialog;
                    Downloader.downloadFiles(this.TO_DOWNLOAD, fc.getSelectedFile().getAbsolutePath());
                    
                    progressDialog.setLocationRelativeTo(this);
                    progressDialog.setVisible(true);
                }
            } else
                this.POP_UP_MENU.show(btnPressed, btnPressed.getWidth() / 2, btnPressed.getHeight() / 2);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() instanceof JLabel label) 
            label.setBackground(Color.LIGHT_GRAY);    
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() instanceof JLabel label)
             label.setBackground(this.getBackground());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backPanel;
    private javax.swing.JPanel chanchingPanel;
    private javax.swing.JButton deleteListBtn;
    private javax.swing.JButton downloadListBtn;
    private javax.swing.JPanel gridLayout;
    private javax.swing.JPanel insideChancingPanel;
    private javax.swing.JPanel listPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu myList;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JList<String> programList;
    private javax.swing.JButton returnBtm;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel secundaryPanel;
    // End of variables declaration//GEN-END:variables

} // end MainWindow