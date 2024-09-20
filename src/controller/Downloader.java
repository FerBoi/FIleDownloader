/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import model.Program;
import view.DownloaderStatus;

/**
 *
 * @author Fernando GJ
 */
public class Downloader {
    public static DownloaderStatus viewDownloadStatus;
    public static boolean cancelDownload;
    public static final Semaphore MUTEX = new Semaphore(1);
    
    public static void downloadFiles(List<Program> programs, String savingPath) {
        new Thread(() -> {
            for (Program program : programs) {
                try {                    
                    HttpURLConnection connection = (HttpURLConnection) program.website().openConnection();
                    connection.setRequestMethod("GET");
                    
                    try (InputStream is = connection.getInputStream(); FileOutputStream fos = new FileOutputStream(savingPath + "/" + program.name().toLowerCase() + ".exe")) {
                        byte[] buffer = new byte[4096];
                        int bytesRead = 0;
                        
                        float sizeToDownload = connection.getContentLength();
                        float sizeDownloaded = 0;
                        
                        while ((bytesRead = is.read(buffer)) != -1 && !cancelDownload) {
                            try {
                                MUTEX.acquire();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            if (!cancelDownload) {
                                fos.write(buffer, 0, bytesRead);
                                sizeDownloaded += bytesRead;

                                int progress = (int) (sizeDownloaded / sizeToDownload * 100);
                                SwingUtilities.invokeLater(() -> viewDownloadStatus.changeStatus(progress, program.name()));
                            }

                            MUTEX.release();
                        }
                    }  
                    
                    if (cancelDownload)
                        return;
                } catch (IOException ex) {
                    Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            viewDownloadStatus.closeJDialogCorrectly();
            
        }).start();
    }
    
} // end Downloader