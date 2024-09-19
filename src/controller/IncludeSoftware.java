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
            new Category("Programming", new ImageIcon(Controller.class.getResource("/src/icon_programming.png")), programming()),
            new Category("Tools", new ImageIcon(Controller.class.getResource("/src/icon_tools.png")), tools())};

        return categories;
    }

    private static List<Program> webBrowsers() {
        List<Program> webBrowsers = new ArrayList<>();

        webBrowsers.add(new Program("Opera", convertURItoURL("https://net.geo.opera.com/opera/stable/windows?utm_tryagain=yes")));
        webBrowsers.add(new Program("Opera GX", convertURItoURL("https://net.geo.opera.com/opera_gx/stable/windows?utm_tryagain=yes")));
        webBrowsers.add(new Program("Firefox", convertURItoURL("https://download.mozilla.org/?product=firefox-latest-ssl&os=win64&lang=en-US")));
        
        return webBrowsers;
    }
    
    private static List<Program> messaging() {
        List<Program> messaging = new ArrayList<>();
        
        messaging.add(new Program("Zoom", convertURItoURL("https://zoom.us/client/6.2.0.46690/ZoomInstallerFull.exe?archType=x64")));
        messaging.add(new Program("Discord", convertURItoURL("https://discord.com/api/downloads/distributions/app/installers/latest?channel=stable&platform=win&arch=x64")));
        messaging.add(new Program("WhatsApp", convertURItoURL("https://get.microsoft.com/installer/download/9NKSQGP7F2NH?cid=website_cta_psi")));
        
        return messaging;
    }
    
    private static List<Program> gaming() {
        List<Program> gaming = new ArrayList<>();
        
        gaming.add(new Program("Steam", convertURItoURL("https://cdn.akamai.steamstatic.com/client/installer/SteamSetup.exe")));
        gaming.add(new Program("Epic Games", convertURItoURL("https://launcher-public-service-prod06.ol.epicgames.com/launcher/api/installer/download/EpicGamesLauncherInstaller.msi")));
        
        return gaming;
    }
    
    private static List<Program> media() {
        List<Program> media = new ArrayList<>();
        
        media.add(new Program("VLC", convertURItoURL("https://get.videolan.org/vlc/3.0.21/win64/vlc-3.0.21-win64.exe")));
        media.add(new Program("Audacity", convertURItoURL("https://github.com/audacity/audacity/releases/download/Audacity-3.6.4/audacity-win-3.6.4-64bit.exe")));
        media.add(new Program("Spotify", convertURItoURL("https://download.scdn.co/SpotifySetup.exe")));
        
        return media;
    }
    
    private static List<Program> programming() {
        List<Program> programming = new ArrayList<>();
        
        programming.add(new Program("Netbeans", convertURItoURL("https://archive.apache.org/dist/netbeans/netbeans-installers/19/Apache-NetBeans-19-bin-windows-x64.exe")));
        programming.add(new Program("IntelliJ CE", convertURItoURL("https://download.jetbrains.com/idea/ideaIC-2024.2.2.exe?_gl=1*11befhn*_gcl_au*MTA4NjIyMDQ3MC4xNzIxODE5OTM2*_ga*NTkzNTg5NTQ4LjE3MjE4MTk5Mzc.*_ga_9J976DJZ68*MTcyNjc3MzI0OC42LjEuMTcyNjc3MzU3NC41LjAuMA..")));
        programming.add(new Program("Android Studio", convertURItoURL("https://redirector.gvt1.com/edgedl/android/studio/install/2024.1.2.13/android-studio-2024.1.2.13-windows.exe")));
        programming.add(new Program("Visual Studio Code", convertURItoURL("https://code.visualstudio.com/sha/download?build=stable&os=win32-x64-user")));
        
        return programming;
    }
    
    private static List<Program> tools() {
        List<Program> tools = new ArrayList<>();
        
        tools.add(new Program("WinRAR", convertURItoURL("https://d.winrar.es/d/101z1726775002/HW8oBMixzttrq8baNYTVMw/winrar-x64-701.exe")));
        tools.add(new Program("Gyazo", convertURItoURL("https://files.gyazo.com/setup/Gyazo-5.6.1.exe?_ga=2.12806903.1387779997.1726774981-1004225417.1716839576")));
        tools.add(new Program("Rainmeter", convertURItoURL("https://github.com/rainmeter/rainmeter/releases/download/v4.5.20.3803/Rainmeter-4.5.20.exe")));
        tools.add(new Program("Logitech G HUB", convertURItoURL("https://download01.logi.com/web/ftp/pub/techsupport/gaming/lghub_installer.exe")));
        tools.add(new Program("OBS Studio", convertURItoURL("https://cdn-fastly.obsproject.com/downloads/OBS-Studio-30.2.3-Windows-Installer.exe")));
        
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