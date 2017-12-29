/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Ball {
    public Point pos = new Point();
    public int x,y;
    public int speedx;
    public Color CurrentColor;
    public egg eggs = new egg();
    public Ball(int x,int y,int speedx,Color color)
    {
        
        pos.x=x;
        pos.y=y;
        this.speedx=speedx;
        this.CurrentColor=color;
        eggs.imgPath="C:\\Users\\MATRIX\\Desktop\\TankGame\\egg.png";
        eggs.pos.x=pos.x+15;
        eggs.pos.y=pos.y;
    }
    public Ball()
    {
        eggs.pos.x=pos.x+15;
        eggs.pos.y=pos.y;
        pos.x=0;
        pos.y=0;
        speedx=20;
        CurrentColor=Color.GREEN;
        eggs.imgPath="C:\\Users\\MATRIX\\Desktop\\TankGame\\egg.png";
    }
    public void move(int width)
    {
        pos.x+=speedx;
        if (pos.x+50>width)
        {
            speedx= -speedx;
        }
        if (pos.x<0)
        {
            speedx= -speedx;
        }
    }

}
