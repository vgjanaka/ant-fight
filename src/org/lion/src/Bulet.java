/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lion.src;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Janaka Pathma Kumara
 */
public class Bulet {

    private int x;
    private int y;
    private boolean live;
    private Image imgBulet;

    public Bulet(int x, int y, boolean live, String path) {
        this.x = x;
        this.y = y;
        this.live = live;
        ImageIcon ic = new ImageIcon(path);
        imgBulet = ic.getImage();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 50);
    }

    public void move() {
        x = x + 2;
        if (x > 600) {
            live = false;
        }
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the live
     */
    public boolean isLive() {
        return live;
    }

    /**
     * @param live the live to set
     */
    public void setLive(boolean live) {
        this.live = live;
    }

    /**
     * @return the imgBulet
     */
    public Image getImgBulet() {
        return imgBulet;
    }

    /**
     * @param imgBulet the imgBulet to set
     */
    public void setImgBulet(Image imgBulet) {
        this.imgBulet = imgBulet;
    }

}
