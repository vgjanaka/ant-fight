/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lion.src;

import org.lion.src.setings.LevelSet1;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.lion.src.setings.LevelSet2;
import org.lion.src.setings.LevelSet3;
import org.lion.src.setings.LevelSet4;
import org.lion.src.setings.LevelSet5;

/**
 *
 * @author Janaka Pathma Kumara
 */
public class LionCode {

    
    public void serialize1(boolean b1) {

        LevelSet1 ls = new  LevelSet1();
        ls.setLevel(b1);
        try {

            FileOutputStream fout = new FileOutputStream("./Set1.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(ls);
            oos.close();
            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
     public void serialize2(boolean b1) {

        LevelSet2 ls = new  LevelSet2();
        ls.setLevel(b1);
        try {

            FileOutputStream fout = new FileOutputStream("./Set2.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(ls);
            oos.close();
            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     
      public void serialize3(boolean b1) {

        LevelSet3 ls = new  LevelSet3();
        ls.setLevel(b1);
        try {

            FileOutputStream fout = new FileOutputStream("./Set3.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(ls);
            oos.close();
            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
      
       public void serialize4(boolean b1) {

        LevelSet4 ls = new  LevelSet4();
        ls.setLevel(b1);
        try {

            FileOutputStream fout = new FileOutputStream("./Set4.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(ls);
            oos.close();
            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
       
        public void serialize5(boolean b1) {

        LevelSet5 ls = new  LevelSet5();
        ls.setLevel(b1);
        try {

            FileOutputStream fout = new FileOutputStream("./Set5.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(ls);
            oos.close();
            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        LionCode ls = new LionCode();
        ls.serialize1(true);
        ls.serialize2(false);
        ls.serialize3(false);
        ls.serialize4(false);
        ls.serialize5(false);
    }
    public LevelSet1 deserialze1() {

        LevelSet1 ls;

        try {

            FileInputStream fin = new FileInputStream("./Set1.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            ls = (LevelSet1) ois.readObject();
            ois.close();

            return ls;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public LevelSet2 deserialze2() {

        LevelSet2 ls;

        try {

            FileInputStream fin = new FileInputStream("./Set2.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            ls = (LevelSet2) ois.readObject();
            ois.close();

            return ls;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public LevelSet3 deserialze3() {

        LevelSet3 ls;

        try {

            FileInputStream fin = new FileInputStream("./Set3.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            ls = (LevelSet3) ois.readObject();
            ois.close();

            return ls;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public LevelSet4 deserialze4() {

        LevelSet4 ls;

        try {

            FileInputStream fin = new FileInputStream("./Set4.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            ls = (LevelSet4) ois.readObject();
            ois.close();

            return ls;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public LevelSet5 deserialze5() {

        LevelSet5 ls;

        try {

            FileInputStream fin = new FileInputStream("./Set5.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            ls = (LevelSet5) ois.readObject();
            ois.close();

            return ls;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public static void OpenLink(String path) {
        try {
            java.awt.Desktop.getDesktop().browse(new URI(path));
        } catch (Exception ex) {
            Logger.getLogger(LionCode.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void OpenFile(String url) {
        try {
            File htmlFile = new File(url);
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (Exception ex) {
            Logger.getLogger(LionCode.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * If possible this method opens the default browser to the specified web
     * page. If not it notifies the user of webpage's url so that they may
     * access it manually.
     *     
* @param url - this can be in the form of a web address
     * (http://www.mywebsite.com) or a path to an html file or SVG image file
     * e.t.c
     */
    public static void openInBrowser(String url) {
        try {
            URI uri = new URL(url).toURI();
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(uri);
            }
        } catch (Exception e) {
            /*
             *  I know this is bad practice 
             *  but we don't want to do anything clever for a specific error
             */
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);

            // Copy URL to the clipboard so the user can paste it into their browser
            StringSelection stringSelection = new StringSelection(url);
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
            // Notify the user of the failure
//            WindowTools.informationWindow("This program just tried to open a webpage." + "\n"
//                    + "The URL has been copied to your clipboard, simply paste into your browser to access.",
//                    "Webpage: " + url);
        }
    }
}
