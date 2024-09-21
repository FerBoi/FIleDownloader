/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

package view;

import controller.Downloader;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando GJ
 */
public class DownloaderStatus extends javax.swing.JDialog implements WindowListener {

    /** Creates new form DownloaderStatus */
    public DownloaderStatus(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.addWindowListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        program = new javax.swing.JLabel();
        inputProgramName = new javax.swing.JLabel();
        currentProgramStatus = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        program.setText("Current Program:");

        currentProgramStatus.setIndeterminate(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(currentProgramStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(program)
                        .addGap(18, 18, 18)
                        .addComponent(inputProgramName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(program)
                    .addComponent(inputProgramName, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(currentProgramStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void changeStatus(String programName) {
        if(!this.inputProgramName.getText().equals(programName))
            this.inputProgramName.setText(programName);
    }
    
    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            Downloader.MUTEX.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(DownloaderStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        int result = JOptionPane.showConfirmDialog(this, "This will cancel all downloads. Continue?", "WARNING", JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            Downloader.cancelDownload = true;
            this.dispose();
        }

        Downloader.MUTEX.release();
    }
    
    public void closeJDialogCorrectly() {
        JOptionPane.showConfirmDialog(this, "All downloads completed!", "SUCCESS", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar currentProgramStatus;
    private javax.swing.JLabel inputProgramName;
    private javax.swing.JLabel program;
    // End of variables declaration//GEN-END:variables

} // end DownloaderStatus