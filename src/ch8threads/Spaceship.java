/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Spaceship {
    public Point pos=new Point();
    public String ImagePath;
    public Bullet Rocket=new Bullet();
    public int speed;
    public int health;
    public Spaceship (String ImagePath)
    {
        health = 20;
        speed=20;
        this.ImagePath=ImagePath;
        Rocket.imgPath="C:\\Users\\MATRIX\\Desktop\\TankGame\\bullet.png";
    }
    void mover() {
        this.pos.x+=speed;
    }
    void movel() {
        this.pos.x-=speed;
    }

    public void fireBullet() {
        Rocket.pos.x=this.pos.x + 42;
        Rocket.pos.y=this.pos.y;
        Thread t1=new Thread (Rocket);
        t1.start();
    }
}
