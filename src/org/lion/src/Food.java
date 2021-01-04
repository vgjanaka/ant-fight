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
public class Food {

    private int x;
    private int y;
    private Image foodImage;

    private int width;
    private int hieht;

    public Food(int x, int y, String path) {
        this.x = x;
        this.y = y;
        foodImage = new ImageIcon(path).getImage();
        width = 200;
        hieht = 174;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getWidth(), getHieht());
    }

    public void move(int dx, int left) {
        if (dx == 2 && !((left + dx) < 150 - 180))//Added this to only move enemy when character moves forward (not back)
        {
            x = x - dx;
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
     * @return the foodImage
     */
    public Image getFoodImage() {
        return foodImage;
    }

    /**
     * @param foodImage the foodImage to set
     */
    public void setFoodImage(Image foodImage) {
        this.foodImage = foodImage;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the hieht
     */
    public int getHieht() {
        return hieht;
    }

    /**
     * @param hieht the hieht to set
     */
    public void setHieht(int hieht) {
        this.hieht = hieht;
    }

}
