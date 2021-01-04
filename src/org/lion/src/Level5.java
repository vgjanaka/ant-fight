 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lion.src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.lion.gui.GameWindow;
import org.lion.gui.mainWindow;

/**
 *
 * @author Janaka Pathma Kumara
 */
public class Level5 extends JPanel {

    Toolkit toolkit;
    Timer timer;

    private boolean finish = false;
    private boolean lifeLost = false;
    private boolean enemyLost = false;
    private boolean gameEnd = false;
    private boolean frut = false;
    private boolean startMSG = false;

    private boolean Level1End = false;
    private boolean Level1Finsh = false;
    private boolean TimeEnd = false;
    private boolean LevelWindow = false;
    private boolean GameLoop = true;

    Image bakImag;
    Ant ant;
    Enemy en1, en2, en3, en4, en5, en6, en7, en8, en9, en10, en11, en12;
    LifeMSG lifeMSG = new LifeMSG(new ImageIcon("./Gimg/life b1.png").getImage());
    MSGImage msg1 = new MSGImage(10, 100, "./Gimg/Msg/L1 Msg1.png");
    MSGImage msg2 = new MSGImage(100, 220, "./Gimg/Msg/L1 Msg7.png");
    MSGImage lifeLostMSG = new MSGImage(50, 50, "./Gimg/Msg/L1 Msg2.png");
    MSGImage enlostMSG = new MSGImage(350, 50, "./Gimg/Msg/L1 Msg3.png");
    MSGImage getFrut = new MSGImage(200, 150, "./Gimg/Msg/L1 Msg4.png");
    MSGImage finshMSG = new MSGImage(30, 100, "./Gimg/Msg/L1 Msg5.png");
    MSGImage endMSG = new MSGImage(100, 110, "./Gimg/Msg/L1 Msg6.png");
    Food banana = new Food(3400, 100, "./Gimg/Fruit_Basket.png");
    Font font = new Font("SanSerif", Font.BOLD, 30);
    GameWindow Gwindow;
    mainWindow mWin;
    Sound sound = new Sound("./mp3/jungle.wav");

    public Level5(GameWindow window, int seconds,mainWindow main) {

        sound.play();
        sound.loop();

        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000);
        Gwindow = window;
         mWin = main;
        setFocusable(true);
        addKeyListener(new Level1Key());
        ImageIcon icon = new ImageIcon("./Gimg/level5.jpg");
        bakImag = icon.getImage();
        ant = new Ant();
        ant.setEndValue(3450);
        ant.setBulletSize(13);
        en1 = new Enemy(300, 350, "./Gimg/Enemy/Spider.png");
        en2 = new Enemy(en1.getX() + 250, 300, "./Gimg/Enemy/frog.png");
        en3 = new Enemy(en2.getX() + 250, 300, "./Gimg/Enemy/snake.png");
        en4 = new Enemy(en3.getX() + 250, 300, "./Gimg/Enemy/animal.png");
        en5 = new Enemy(en4.getX() + 250, 350, "./Gimg/Enemy/Spider.png");
        en6 = new Enemy(en5.getX() + 250, 300, "./Gimg/Enemy/frog.png");
        en7 = new Enemy(en6.getX() + 250, 300, "./Gimg/Enemy/snake.png");
        en8 = new Enemy(en7.getX() + 250, 300, "./Gimg/Enemy/animal.png");
        en9 = new Enemy(en8.getX() + 250, 350, "./Gimg/Enemy/Spider.png");
        en10 = new Enemy(en9.getX() + 250, 300, "./Gimg/Enemy/frog.png");
        en11 = new Enemy(en10.getX() + 250, 300, "./Gimg/Enemy/snake.png");
        en12 = new Enemy(en11.getX() + 250, 300, "./Gimg/Enemy/animal.png");
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (isGameLoop()) {
                    System.out.println("sss");
                    checkCollisions();
                    checkLife();
                    ArrayList bullets = ant.getBullet();
                    for (int w = 0; w < bullets.size(); w++) {
                        Bulet m = (Bulet) bullets.get(w);
                        if (m.isLive() == true) {
                            m.move();
                        } else {
                            bullets.remove(w);
                        }
                    }
                    ant.move();

                    en1.move(ant.getDx(), ant.getLeft());
                    en2.move(ant.getDx(), ant.getLeft());
                    en3.move(ant.getDx(), ant.getLeft());
                    en4.move(ant.getDx(), ant.getLeft());
                    en5.move(ant.getDx(), ant.getLeft());
                    en6.move(ant.getDx(), ant.getLeft());
                    en7.move(ant.getDx(), ant.getLeft());
                    en8.move(ant.getDx(), ant.getLeft());
                    en9.move(ant.getDx(), ant.getLeft());
                    en10.move(ant.getDx(), ant.getLeft());
                    en11.move(ant.getDx(), ant.getLeft());
                    en12.move(ant.getDx(), ant.getLeft());
                    banana.move(ant.getDx(), ant.getLeft());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Level1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    repaint();
                }
            }
        }).start();

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
                    System.out.println(clip.isRunning());
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (isLevel1End()) {
            g2d.drawImage(new ImageIcon("./Gimg/gameOver.png").getImage(), 0, 0, null);
            setGameLoop(false);
            sound.stop();
            Gwindow.dispose();
            new GameEndMSG(mWin,5).setVisible(true);
        } else if (isLevel1Finsh()) {
            g2d.drawImage(new ImageIcon("./Gimg/gameFinish.png").getImage(), 0, 0, null);
            setGameLoop(false);
            sound.stop();
            Gwindow.dispose();
            new GameWinMsg(mWin,5).setVisible(true);
        } else if (isTimeEnd()) {
            g2d.drawImage(new ImageIcon("./Gimg/gameTimeOver.png").getImage(), 0, 0, null);
            setGameLoop(false);
            sound.stop();
            Gwindow.dispose();
            new TimeOverMSG(mWin,5).setVisible(true);
        } else {
            g2d.drawImage(bakImag, 685 - ant.getNx2(), 0, null);
            g2d.drawImage(new ImageIcon("./Gimg/Nlogo.png").getImage(), 10, 10, null);
            g2d.drawImage(new ImageIcon("./Gimg/l5.png").getImage(), 150, 10, null);
            g2d.drawImage(new ImageIcon("./Gimg/Bullet src.png").getImage(), 300, 10, null);
            g2d.setFont(font);
            g2d.setColor(Color.BLUE);
            g2d.drawString("" + ant.getBulletSize(), 450, 40);
            g2d.drawImage(new ImageIcon("./Gimg/life.png").getImage(), 500, 10, null);
            g2d.drawImage(lifeMSG.getLifeMSGimg(), 600, 10, null);

            if (isLifeLost()) {
                g2d.drawImage(lifeLostMSG.getMsgImage(), lifeLostMSG.getX(), lifeLostMSG.getY(), null);
                lifeLostMSG.upDate5(5, this, 1);
            }
            if (isEnemyLost()) {
                g2d.drawImage(enlostMSG.getMsgImage(), enlostMSG.getX(), enlostMSG.getY(), null);
                enlostMSG.upDate5(5, this, 2);
            }
            if (isFrut()) {
                g2d.drawImage(getFrut.getMsgImage(), getFrut.getX(), getFrut.getY(), null);
                getFrut.upDate5(5, this, 3);
            }
//            if (isFinish()) {
//                g2d.drawImage(finshMSG.getMsgImage(), finshMSG.getX(), finshMSG.getY(), null);
//                finshMSG.upDate(5, this, 4);
//            }
//            if (isGameEnd()) {
//                g2d.drawImage(endMSG.getMsgImage(), endMSG.getX(), endMSG.getY(), null);
//                endMSG.upDate(5, this, 5);
//            }
            System.out.println(ant.getX());
            if (ant.getX() < 100) {
                setStartMSG(true);
            } else {
                setStartMSG(false);
            }

            if (ant.getX() > 1000 && ant.getX() < 1100) {
                setFrut(true);
            } else {
                setFrut(false);
            }
            
            if (ant.getX() > 3200 && ant.getX() < 3350) {
                setFrut(true);
            } else {
                setFrut(false);
            }
            if (isStartMSG()) {
                g2d.drawImage(msg1.getMsgImage(), msg1.getX(), msg1.getY(), null);
            }

            if (isStartMSG()) {
                g2d.drawImage(msg2.getMsgImage(), msg2.getX(), msg2.getY(), null);
            }

            if (en1.isLive()) {
                g2d.drawImage(en1.getEnemy(), en1.getX(), en1.getY(), null);
            }
            if (en2.isLive()) {
                g2d.drawImage(en2.getEnemy(), en2.getX(), en2.getY(), null);

            }
            if (en3.isLive()) {
                g2d.drawImage(en3.getEnemy(), en3.getX(), en3.getY(), null);

            }

            if (en4.isLive()) {
                g2d.drawImage(en4.getEnemy(), en4.getX(), en4.getY(), null);

            }
            if (en5.isLive()) {
                g2d.drawImage(en5.getEnemy(), en5.getX(), en5.getY(), null);

            }
            if (en6.isLive()) {
                g2d.drawImage(en6.getEnemy(), en6.getX(), en6.getY(), null);

            }
            if (en7.isLive()) {
                g2d.drawImage(en7.getEnemy(), en7.getX(), en7.getY(), null);

            }
            if (en8.isLive()) {
                g2d.drawImage(en8.getEnemy(), en8.getX(), en8.getY(), null);

            }
            if (en9.isLive()) {
                g2d.drawImage(en9.getEnemy(), en9.getX(), en9.getY(), null);

            }

            if (en10.isLive()) {
                g2d.drawImage(en10.getEnemy(), en10.getX(), en10.getY(), null);

            }

            if (en11.isLive()) {
                g2d.drawImage(en11.getEnemy(), en11.getX(), en11.getY(), null);

            }
            if (en12.isLive()) {
                g2d.drawImage(en12.getEnemy(), en12.getX(), en12.getY(), null);

            }

            g2d.drawImage(banana.getFoodImage(), banana.getX(), ant.getY(), null);

            g2d.drawImage(ant.getAntImg(), 30, ant.getY(), null);

            ArrayList bullets = ant.getBullet();
            for (int w = 0; w < bullets.size(); w++) {
                Bulet m = (Bulet) bullets.get(w);
                if (m.isLive()) {
                    g2d.drawImage(m.getImgBulet(), m.getX(), m.getY(), null);
                }
            }

        }
    }

    public void checkCollisions() {;
        Rectangle r1 = en1.getBounds();
        Rectangle r2 = en2.getBounds();
        Rectangle r3 = en3.getBounds();
        Rectangle r4 = en4.getBounds();
        Rectangle r5 = en5.getBounds();
        Rectangle r6 = en6.getBounds();
        Rectangle r7 = en7.getBounds();
        Rectangle r8 = en8.getBounds();
        Rectangle r9 = en9.getBounds();
        Rectangle r10 = en10.getBounds();
        Rectangle r11 = en11.getBounds();
        Rectangle r12 = en12.getBounds();
        ArrayList bullets = ant.getBullet();
        for (int w = 0; w < bullets.size(); w++) {
            Bulet m = (Bulet) bullets.get(w);
            Rectangle m1 = m.getBounds();
            if (r1.intersects(m1) && en1.isLive()) {
                playSound("./mp3/Bomb.wav");
                en1.setLive(false);
                en1.setLife(false);
                m.setLive(false);
                if (!isLevel1End()) {
                    setEnemyLost(true);

                }
            } else if (r2.intersects(m1) && en2.isLive()) {
                playSound("./mp3/Bomb.wav");
                en2.setLive(false);
                en2.setLife(false);
                m.setLive(false);
                if (!isLevel1End()) {
                    setEnemyLost(true);

                }
            } else if (r3.intersects(m1) && en3.isLive()) {
                playSound("./mp3/Bomb.wav");
                en3.setLive(false);
                en3.setLife(false);
                m.setLive(false);
                if (!isLevel1End()) {
                    setEnemyLost(true);

                }
            } else if (r4.intersects(m1) && en4.isLive()) {
                playSound("./mp3/Bomb.wav");
                en4.setLive(false);
                en4.setLife(false);
                m.setLive(false);
                if (!isLevel1End()) {
                    setEnemyLost(true);

                }
            } else if (r5.intersects(m1) && en5.isLive()) {
                playSound("./mp3/Bomb.wav");
                en5.setLive(false);
                en5.setLife(false);
                m.setLive(false);
                if (!isLevel1End()) {
                    setEnemyLost(true);

                }
            } else if (r6.intersects(m1) && en6.isLive()) {
                playSound("./mp3/Bomb.wav");
                en6.setLive(false);
                en6.setLife(false);
                m.setLive(false);
                if (!isLevel1End()) {
                    setEnemyLost(true);

                }
            } else if (r7.intersects(m1) && en7.isLive()) {
                playSound("./mp3/Bomb.wav");
                en7.setLive(false);
                en7.setLife(false);
                m.setLive(false);
                if (!isLevel1End()) {
                    setEnemyLost(true);

                }
            } else if (r8.intersects(m1) && en8.isLive()) {
                playSound("./mp3/Bomb.wav");
                en8.setLive(false);
                en8.setLife(false);
                m.setLive(false);
                if (!isLevel1End()) {
                    setEnemyLost(true);

                }
            } else if (r9.intersects(m1) && en9.isLive()) {
                playSound("./mp3/Bomb.wav");
                en9.setLive(false);
                en9.setLife(false);
                m.setLive(false);
                if (!isLevel1End()) {
                    setEnemyLost(true);

                }
            } else if (r10.intersects(m1) && en10.isLive()) {
                playSound("./mp3/Bomb.wav");
                en10.setLive(false);
                en10.setLife(false);
                m.setLive(false);
                if (!isLevel1End()) {
                    setEnemyLost(true);

                }
            } else if (r11.intersects(m1) && en11.isLive()) {
                playSound("./mp3/Bomb.wav");
                en11.setLive(false);
                en11.setLife(false);
                m.setLive(false);
                if (!isLevel1End()) {
                    setEnemyLost(true);

                }
            }
            else if (r12.intersects(m1) && en12.isLive()) {
                playSound("./mp3/Bomb.wav");
                en12.setLive(false);
                en12.setLife(false);
                m.setLive(false);
                if (!isLevel1End()) {
                    setEnemyLost(true);

                }
            }
        }

        Rectangle d = ant.getBounds();
        Rectangle rbanana = banana.getBounds();
        if (d.intersects(rbanana)) {
            setFinish(true);
            setLevel1Finsh(false);
            setLevel1Finsh(true);
            playSound("./mp3/Ta Da.wav");

        }
        if (d.intersects(r1) && en1.isLife()) {
            en1.setLife(false);
            ant.RestLife();
            setLifeLost(true);
            playSound("./mp3/punch2.wav");
        }
        if (d.intersects(r2) && en2.isLife()) {
            en2.setLife(false);
            ant.RestLife();
            setLifeLost(true);
            playSound("./mp3/punch2.wav");
        }
        if (d.intersects(r3) && en3.isLife()) {
            en3.setLife(false);
            ant.RestLife();
            setLifeLost(true);
            playSound("./mp3/punch2.wav");
        }
        if (d.intersects(r4) && en4.isLife()) {
            en4.setLife(false);
            ant.RestLife();
            setLifeLost(true);
            playSound("./mp3/punch2.wav");
        }
        if (d.intersects(r5) && en5.isLife()) {
            en5.setLife(false);
            ant.RestLife();
            setLifeLost(true);
            playSound("./mp3/punch2.wav");
        }

        if (d.intersects(r6) && en6.isLife()) {
            en6.setLife(false);
            ant.RestLife();
            setLifeLost(true);
            playSound("./mp3/punch2.wav");
        }
        if (d.intersects(r7) && en7.isLife()) {
            en7.setLife(false);
            ant.RestLife();
            setLifeLost(true);
            playSound("./mp3/punch2.wav");
        }
        if (d.intersects(r8) && en8.isLife()) {
            en8.setLife(false);
            ant.RestLife();
            setLifeLost(true);
            playSound("./mp3/punch2.wav");
        }
        if (d.intersects(r9) && en9.isLife()) {
            en9.setLife(false);
            ant.RestLife();
            setLifeLost(true);
            playSound("./mp3/punch2.wav");
        }

        if (d.intersects(r10) && en10.isLife()) {
            en10.setLife(false);
            ant.RestLife();
            setLifeLost(true);
            playSound("./mp3/punch2.wav");
        }

        if (d.intersects(r11) && en11.isLife()) {
            en11.setLife(false);
            ant.RestLife();
            setLifeLost(true);
            playSound("./mp3/punch2.wav");
        }
        
        if (d.intersects(r12) && en12.isLife()) {
            en12.setLife(false);
            ant.RestLife();
            setLifeLost(true);
            playSound("./mp3/punch2.wav");
        }
    }

    public void checkLife() {
        if (ant.getLife() == 3) {
            lifeMSG.setLifeMSGimg(new ImageIcon("./Gimg/life b1.png").getImage());
        } else if (ant.getLife() == 2) {
            lifeMSG.setLifeMSGimg(new ImageIcon("./Gimg/life b2.png").getImage());
        } else if (ant.getLife() == 1) {
            lifeMSG.setLifeMSGimg(new ImageIcon("./Gimg/life b3.png").getImage());

        } else {
            lifeMSG.setLifeMSGimg(null);
            setGameEnd(true);
            setLevel1End(true);
        }
    }

    /**
     * @return the finish
     */
    public boolean isFinish() {
        return finish;
    }

    /**
     * @param finish the finish to set
     */
    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    /**
     * @return the lifeLost
     */
    public boolean isLifeLost() {
        return lifeLost;
    }

    /**
     * @param lifeLost the lifeLost to set
     */
    public void setLifeLost(boolean lifeLost) {
        this.lifeLost = lifeLost;
    }

    /**
     * @return the enemyLost
     */
    public boolean isEnemyLost() {
        return enemyLost;
    }

    /**
     * @param enemyLost the enemyLost to set
     */
    public void setEnemyLost(boolean enemyLost) {
        this.enemyLost = enemyLost;
    }

    /**
     * @return the gameEnd
     */
    public boolean isGameEnd() {
        return gameEnd;
    }

    /**
     * @param gameEnd the gameEnd to set
     */
    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }

    /**
     * @return the frut
     */
    public boolean isFrut() {
        return frut;
    }

    /**
     * @param frut the frut to set
     */
    public void setFrut(boolean frut) {
        this.frut = frut;
    }

    /**
     * @return the startMSG
     */
    public boolean isStartMSG() {
        return startMSG;
    }

    /**
     * @param startMSG the startMSG to set
     */
    public void setStartMSG(boolean startMSG) {
        this.startMSG = startMSG;
    }

    /**
     * @return the Level1End
     */
    public boolean isLevel1End() {
        return Level1End;
    }

    /**
     * @param Level1End the Level1End to set
     */
    public void setLevel1End(boolean Level1End) {
        this.Level1End = Level1End;
    }

    /**
     * @return the Level1Finsh
     */
    public boolean isLevel1Finsh() {
        return Level1Finsh;
    }

    /**
     * @param Level1Finsh the Level1Finsh to set
     */
    public void setLevel1Finsh(boolean Level1Finsh) {
        this.Level1Finsh = Level1Finsh;
    }

    /**
     * @return the TimeEnd
     */
    public boolean isTimeEnd() {
        return TimeEnd;
    }

    /**
     * @param TimeEnd the TimeEnd to set
     */
    public void setTimeEnd(boolean TimeEnd) {
        this.TimeEnd = TimeEnd;
    }

    /**
     * @return the LevelWindow
     */
    public boolean isLevelWindow() {
        return LevelWindow;
    }

    /**
     * @param LevelWindow the LevelWindow to set
     */
    public void setLevelWindow(boolean LevelWindow) {
        this.LevelWindow = LevelWindow;
    }

    /**
     * @return the GameLoop
     */
    public boolean isGameLoop() {
        return GameLoop;
    }

    /**
     * @param GameLoop the GameLoop to set
     */
    public void setGameLoop(boolean GameLoop) {
        this.GameLoop = GameLoop;
    }

    class RemindTask extends TimerTask {

        public void run() {
//            System.out.println("Time's up!");
            toolkit.beep();
            setTimeEnd(true);
//            System.exit(0);

        }
    }

    class Level1Key extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            ant.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            ant.keyReleased(e);
        }
    }
}
