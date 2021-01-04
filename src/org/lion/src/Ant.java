/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lion.src;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

/**
 *
 * @author Janaka Pathma Kumara
 */
public class Ant {

    private int x;
    private int y;
    private int dx;
    private int dy;
    private int left;
    private int nx;
    private int nx2;
    private int life;
    private Image antImg;
    private int bulletSize;
    private ArrayList<Bulet> bullet;
    private int width;
    private int hieht;
    private int endValue;
    
    
    public Ant() {
        x = 75;
        y = 250;
        left = 150;
        nx = 0;
        nx2 = 685;
        bulletSize = 6;
        life = 3;
        ImageIcon ImgIcon = new ImageIcon("./Gimg/ant/ant4.png");
        antImg = ImgIcon.getImage();
        bullet = new ArrayList<>();
        width = 100;
        hieht =208;

    }

    public void RestLife() {
        life = life - 1;
        System.out.println(life);
    }

    public Rectangle getBounds() {
        return new Rectangle(left - 180, y, getWidth(), getHieht());
    }

    public void move() {
        if (dx != -1) {
            if (getLeft() + dx <= 150) {
                setLeft(getLeft() + dx);
            } else {
                if (getX() >= getEndValue()) {
                    dx =0;
                } else {
                    x = x + dx;

                }

                setNx2(getNx2() + dx);
                setNx(getNx() + dx);
            }
        } else {
            if (getLeft() + dx > 0) {
                setLeft(getLeft() + dx);
            }
        }
    }

    public void fire() {
        if (getBulletSize() > 0) {
            setBulletSize(getBulletSize() - 1);
            Bulet bu = new Bulet((left + 10), 400, true, "./Gimg/bullet1.png");
            getBullet().add(bu);
            playSound("./mp3/Gunshots.wav");
        }

    }

     public synchronized void playSound(final String url) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(url));
                        clip.open(inputStream);
                        clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
    
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (getX() > getEndValue()) {
                dx = 0;
            } else {
                dx = 2;
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dx = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            fire();
        }

    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dx = 0;
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
     * @return the dx
     */
    public int getDx() {
        return dx;
    }

    /**
     * @param dx the dx to set
     */
    public void setDx(int dx) {
        this.dx = dx;
    }

    /**
     * @return the dy
     */
    public int getDy() {
        return dy;
    }

    /**
     * @param dy the dy to set
     */
    public void setDy(int dy) {
        this.dy = dy;
    }

    /**
     * @return the antImg
     */
    public Image getAntImg() {
        return antImg;
    }

    /**
     * @param antImg the antImg to set
     */
    public void setAntImg(Image antImg) {
        this.antImg = antImg;
    }

    /**
     * @return the life
     */
    public int getLife() {
        return life;
    }

    /**
     * @param life the life to set
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * @return the bullet
     */
    public ArrayList<Bulet> getBullet() {
        return bullet;
    }

    /**
     * @param aBullet the bullet to set
     */
    public void setBullet(ArrayList<Bulet> aBullet) {
        bullet = aBullet;
    }

    /**
     * @return the left
     */
    public int getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(int left) {
        this.left = left;
    }

    /**
     * @return the nx
     */
    public int getNx() {
        return nx;
    }

    /**
     * @param nx the nx to set
     */
    public void setNx(int nx) {
        this.nx = nx;
    }

    /**
     * @return the nx2
     */
    public int getNx2() {
        return nx2;
    }

    /**
     * @param nx2 the nx2 to set
     */
    public void setNx2(int nx2) {
        this.nx2 = nx2;
    }

    /**
     * @return the bulletSize
     */
    public int getBulletSize() {
        return bulletSize;
    }

    /**
     * @param bulletSize the bulletSize to set
     */
    public void setBulletSize(int bulletSize) {
        this.bulletSize = bulletSize;
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

    /**
     * @return the endValue
     */
    public int getEndValue() {
        return endValue;
    }

    /**
     * @param endValue the endValue to set
     */
    public void setEndValue(int endValue) {
        this.endValue = endValue;
    }
}
