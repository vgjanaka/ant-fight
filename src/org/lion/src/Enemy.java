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
public class Enemy {

    private int x;
    private int y;
    private Image enemy;
    private boolean Live;
    private boolean life;

    
    private int width;
    private int hieht;

    public Enemy(int x, int y, String Path) {
        this.x = x;
        this.y = y;
        ImageIcon ic = new ImageIcon(Path);
        enemy = ic.getImage();
        Live = true;
        life = true;
        width = 128;
        hieht = 128;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, getWidth(), getHieht());
    }

    public void move(int dx, int left) {
        if (dx == 2 && !((left + dx) < 150-180))//Added this to only move enemy when character moves forward (not back)
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
     * @return the enemy
     */
    public Image getEnemy() {
        return enemy;
    }

    /**
     * @param enemy the enemy to set
     */
    public void setEnemy(Image enemy) {
        this.enemy = enemy;
    }

    /**
     * @return the Live
     */
    public boolean isLive() {
        return Live;
    }

    /**
     * @param Live the Live to set
     */
    public void setLive(boolean Live) {
        this.Live = Live;
    }

    /**
     * @return the life
     */
    public boolean isLife() {
        return life;
    }

    /**
     * @param life the life to set
     */
    public void setLife(boolean life) {
        this.life = life;
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
