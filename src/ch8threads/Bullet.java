/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Bullet implements Runnable{
    public Point pos=new Point();
    public Color CurrentColor;
    public int Speed;
    public String imgPath;
    public Bullet()
    {
        Speed=5;
    }
    public  void  move()
    {
        pos.y-=Speed;
    }

    @Override
    public void run() {
        for (int i=0;i<4000;i++)
        {
            //System.out.println("Rocket Moving " +pos.y);
            move();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                
            }
            
        }
    }
}
