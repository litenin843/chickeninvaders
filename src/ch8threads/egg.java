/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8threads;

import java.awt.Point;

/**
 *
 * @author MATRIX
 */
public class egg implements Runnable {
    public Point pos=new Point();
    public int Speed;
    public String imgPath;
    public egg()
    {
    Speed = 5;
    }
    public void drop()
    {
        pos.y+= Speed;
    }
    @Override
    public void run() {
        for (int i=0;i<4000;i++)
        {
            drop();
        }
    }
    
}
