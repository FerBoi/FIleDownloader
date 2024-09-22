/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import model.Category;
import model.Program;

/**
 *
 * @author Fernando GJ
 */
public class IncludeSoftware {
    
    public static Category[] baseCategories() {
        Category[] categories = new Category[]{new Category("Web Browsers", new ImageIcon(Controller.class.getResource("/src/icon_webBrowser.png")), webBrowsers()),
            new Category("Messaging", new ImageIcon(Controller.class.getResource("/src/icon_messaging.png")), messaging()),
            new Category("Gaming", new ImageIcon(Controller.class.getResource("/src/icon_gaming.png")), gaming()),
            new Category("Media", new ImageIcon(Controller.class.getResource("/src/icon_media.png")), media()),
            new Category("Tools", new ImageIcon(Controller.class.getResource("/src/icon_tools.png")), tools())};

        return categories;
    }

    private static List<Program> webBrowsers() {
        List<Program> webBrowsers = new ArrayList<>();

        webBrowsers.add(new Program("Google Chrome", convertURItoURL("https://www.snapfiles.com/downloads/googlechrome/dlgooglechrome.html")));
        webBrowsers.add(new Program("Opera", convertURItoURL("https://www.snapfiles.com/downloads/opera/dlopera.html")));
        webBrowsers.add(new Program("Firefox", convertURItoURL("https://www.mozilla.org/es-ES/firefox/new/")));
        
        return webBrowsers;
    }
    
    private static List<Program> messaging() {
        List<Program> messaging = new ArrayList<>();
        
        messaging.add(new Program("Discord", convertURItoURL("https://discord.com/download")));
        
        return messaging;
    }
    
    private static List<Program> gaming() {
        List<Program> gaming = new ArrayList<>();
        
        gaming.add(new Program("Steam", convertURItoURL("https://store.steampowered.com/about/")));
        
        return gaming;
    }
    
    private static List<Program> media() {
        List<Program> media = new ArrayList<>();
        
        media.add(new Program("VLC", convertURItoURL("https://www.snapfiles.com/downloads/videolan/dlvideolan.html")));
        media.add(new Program("Audacity", convertURItoURL("https://www.audacityteam.org/download/windows/")));
        media.add(new Program("Spotify", convertURItoURL("https://www.spotify.com/es/download/windows/")));
        
        return media;
    }
    
    private static List<Program> tools() {
        List<Program> tools = new ArrayList<>();
        
        tools.add(new Program("WinRAR", convertURItoURL("https://www.snapfiles.com/downloads/winrar/dlwinrar.html")));
        tools.add(new Program("Gyazo", convertURItoURL("https://gyazo.com/download")));
        tools.add(new Program("Rainmeter", convertURItoURL("https://www.rainmeter.net")));
        tools.add(new Program("Logitech G HUB", convertURItoURL("https://www.logitechg.com/es-es/innovation/g-hub.html?srsltid=AfmBOop-V7W_fr0_3Q5n3DyOoMoWAeUZytCvifgvAVR9A53KT4wP61vt")));
        tools.add(new Program("OBS Studio", convertURItoURL("https://obsproject.com/es/download")));
        
        return tools;
    }
    

    private static URL convertURItoURL(String uri) {
        try {
            URL url = new URI(uri).toURL();
            
            return url;
        } catch (URISyntaxException | MalformedURLException e) {
            return null;
        }
    }




} // end IncludeProgram