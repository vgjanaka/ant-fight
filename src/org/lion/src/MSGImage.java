/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lion.src;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Janaka Pathma Kumara
 */
public class MSGImage {

    private int x;
    private int y;
    private Image MsgImage;
    private boolean live;
    private boolean call;

    public MSGImage(int x, int y, String path) {
        this.x = x;
        this.y = y;
        this.MsgImage = new ImageIcon(path).getImage();
        this.live = true;
        this.call = false;
    }

    public void upDate(int w, Level1 l1, int intMSGType) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < w; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MSGImage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (intMSGType == 1) {
                    l1.setLifeLost(false);
                } else if (intMSGType == 2) {
                    l1.setEnemyLost(false);
                } else if (intMSGType == 3) {
                    l1.setFrut(false);
                } else if (intMSGType == 4) {
                    l1.setFinish(false);
                } else if (intMSGType == 5) {
                    l1.setGameEnd(false);
                }
            }
        }).start();
    }
    
     public void upDate2(int w, Level2 l1, int intMSGType) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < w; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MSGImage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (intMSGType == 1) {
                    l1.setLifeLost(false);
                } else if (intMSGType == 2) {
                    l1.setEnemyLost(false);
                } else if (intMSGType == 3) {
                    l1.setFrut(false);
                } else if (intMSGType == 4) {
                    l1.setFinish(false);
                } else if (intMSGType == 5) {
                    l1.setGameEnd(false);
                }
            }
        }).start();
    }
     
      public void upDate3(int w, Level3 l1, int intMSGType) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < w; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MSGImage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (intMSGType == 1) {
                    l1.setLifeLost(false);
                } else if (intMSGType == 2) {
                    l1.setEnemyLost(false);
                } else if (intMSGType == 3) {
                    l1.setFrut(false);
                } else if (intMSGType == 4) {
                    l1.setFinish(false);
                } else if (intMSGType == 5) {
                    l1.setGameEnd(false);
                }
            }
        }).start();
    }
      
       public void upDate4(int w, Level4 l1, int intMSGType) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < w; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MSGImage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (intMSGType == 1) {
                    l1.setLifeLost(false);
                } else if (intMSGType == 2) {
                    l1.setEnemyLost(false);
                } else if (intMSGType == 3) {
                    l1.setFrut(false);
                } else if (intMSGType == 4) {
                    l1.setFinish(false);
                } else if (intMSGType == 5) {
                    l1.setGameEnd(false);
                }
            }
        }).start();
    }
       
        public void upDate5(int w, Level5 l1, int intMSGType) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < w; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MSGImage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (intMSGType == 1) {
                    l1.setLifeLost(false);
                } else if (intMSGType == 2) {
                    l1.setEnemyLost(false);
                } else if (intMSGType == 3) {
                    l1.setFrut(false);
                } else if (intMSGType == 4) {
                    l1.setFinish(false);
                } else if (intMSGType == 5) {
                    l1.setGameEnd(false);
                }
            }
        }).start();
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
     * @return the MsgImage
     */
    public Image getMsgImage() {
        return MsgImage;
    }

    /**
     * @param MsgImage the MsgImage to set
     */
    public void setMsgImage(Image MsgImage) {
        this.MsgImage = MsgImage;
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
     * @return the call
     */
    public boolean isCall() {
        return call;
    }

    /**
     * @param call the call to set
     */
    public void setCall(boolean call) {
        this.call = call;
    }

}
