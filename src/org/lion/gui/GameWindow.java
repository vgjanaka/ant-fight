/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lion.gui;

import javax.swing.JFrame;
import org.lion.src.Level1;
import org.lion.src.Level2;
import org.lion.src.Level3;
import org.lion.src.Level4;
import org.lion.src.Level5;

/**
 *
 * @author Janaka Pathma kumara
 */
public class GameWindow extends JFrame {

    public GameWindow(int type,mainWindow m) {
        if(type==1){
            add(new Level1(this, 15,m));
        }else if(type==2){
             add(new Level2(this, 20,m));
        }else if(type==3){
            add(new Level3(this, 25,m));
        }else if(type==4){
            add(new Level4(this, 30,m));
        }else if(type==5){
            add(new Level5(this, 35,m));
        }
        setSize(700, 500);
        setLocationRelativeTo(null);
        setTitle("Ant Fight");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String[] args) {
//        new GameWindow(5);
    }

}
