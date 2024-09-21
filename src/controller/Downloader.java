/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import model.Program;
import view.DownloaderStatus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

                    String contentType = connection.getContentType();

                    if (!contentType.contains("application")) {
                        connection.disconnect();
                        URL newURL = searchingApplicationLink(program.website().toExternalForm());
                        connection = (HttpURLConnection) newURL.openConnection();
                    }

                    if (connection != null && connection.getResponseCode() == HttpURLConnection.HTTP_OK) { // connection established correctly
                        try (InputStream is = connection.getInputStream(); FileOutputStream fos = new FileOutputStream(savingPath + "/" + program.name().toLowerCase() + ".exe")) {
                            byte[] buffer = new byte[4096];
                            int bytesRead = 0;
                            
                            while ((bytesRead = is.read(buffer)) != -1 && !cancelDownload) {
                                try {
                                    MUTEX.acquire();
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                if (!cancelDownload) {
                                    fos.write(buffer, 0, bytesRead);
                                    SwingUtilities.invokeLater(() -> viewDownloadStatus.changeStatus(program.name()));
                                }

                                MUTEX.release();
                            }
                        }

                        if (cancelDownload) {
                            return;
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            viewDownloadStatus.closeJDialogCorrectly();
        }).start();
    }

    private static URL searchingApplicationLink(String websitePath) throws IOException {
        Document htmlContent = Jsoup.connect(websitePath).get();
        Elements links = htmlContent.select("a[href*=exe], a[href*=msi]");

        if (links != null) {
            List<URI> possibleLinks = new ArrayList<>();
            
            for (Element link : links) {
                String individualLink = link.attr("abs:href");

                try {
                    HttpURLConnection connection = (HttpURLConnection) new URI(individualLink).toURL().openConnection();
                    connection.setRequestMethod("HEAD");  // only obtain the header
                    String contentType = connection.getContentType();
                    
                    // int pcArchitecture = System.getProperty("os.arch").contains("86") ? 86 : 64;
                    
                    if(contentType != null && contentType.contains("application"))
                        possibleLinks.add(new URI(individualLink));
                } catch (URISyntaxException e) {
                    return null;
                }
            }
            
            if(!possibleLinks.isEmpty()) {
                String arch = System.getProperty("os.arch").substring(System.getProperty("os.arch").length()-2);
                
                for (URI possibleLink : possibleLinks) {
                    if(possibleLink.getPath().contains(arch))
                        return possibleLink.toURL();
                }
                
                return possibleLinks.get(0).toURL();
            }
        }

        return null;
    }


    
} // end Downloader