/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author ASUS
 */
public class MovingChickens extends JPanel implements Runnable {
   Random randNum = new Random();
   int min = 100, max = 150;
   int counter = 0;
   public ArrayList<Ball>Chickens=new ArrayList<Ball>(15);
   int score;
   int counttimer = 3;
   int lvl = 1;
   public Spaceship SpaceShp=new Spaceship("C:\\Users\\MATRIX\\Desktop\\TankGame\\hhhhh.png");
   public JLabel countdown = new JLabel();
   public JLabel scoreboard = new JLabel();
   public JLabel level = new JLabel(); 
   public JLabel health = new JLabel(); 

   public void playlvl(int level)
        {
            for (int i = 0; i < level*5; i++)
            {
                int random = min + randNum.nextInt(max);
                int randspeed = 10 + randNum.nextInt(20);
                Chickens.add(new Ball(random,random,randspeed,Color.RED));
            }
        }
    public MovingChickens()
     {
        setSize(1000,600);
        setBackground(Color.red);
        SpaceShp.pos.x=500;
        SpaceShp.pos.y=400;
        countdown.setFont(new Font("Times New Roman",Font.PLAIN, 100));
        level.setFont(new Font("Times New Roman",Font.PLAIN, 50));


        scoreboard.setBounds(500,0,100,100);
        health.setBounds(500,300,100,100);
        countdown.setBounds(scoreboard.getX(), scoreboard.getY() + 300, 100, 100);
        level.setBounds(900,0,100,100);
        level.setText("Level 1");
        health.setForeground(Color.WHITE);

        level.setForeground(Color.WHITE);
        scoreboard.setForeground(Color.WHITE);
        countdown.setForeground(Color.WHITE);
        countdown.setText("3");
        scoreboard.setText("Score: 0");
        health.setText("Health: 20");
        level.setVisible(false);
        add(scoreboard);
        add(countdown);
        add(level);
        add(health);
        this.addKeyListener(new keylist());
    }
    
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                SpaceShp.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                SpaceShp.movel();
                //repaint();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                SpaceShp.fireBullet();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
    public void  paintComponent(Graphics g)
    {
        try
        {
            BufferedImage bg = ImageIO.read(new File("C:\\Users\\MATRIX\\Desktop\\TankGame\\bg.jpg"));
            g.drawImage(bg, 0, 0, this);
            BufferedImage imgsmallchicken = ImageIO.read(new File("C:\\Users\\MATRIX\\Desktop\\TankGame\\smallchicken.png"));  
            BufferedImage eggimg = ImageIO.read(new File("C:\\Users\\MATRIX\\Desktop\\TankGame\\egg.png"));  
            try
            {
                BufferedImage imgtank = ImageIO.read(new File(SpaceShp.ImagePath));
                BufferedImage imgrocket = ImageIO.read(new File(SpaceShp.Rocket.imgPath));
                g.drawImage(imgtank, SpaceShp.pos.x, SpaceShp.pos.y,null);
                g.drawImage(imgrocket, SpaceShp.Rocket.pos.x, SpaceShp.Rocket.pos.y,null);
            }
            catch (IOException e)
            {
                System.out.println(e);
            }
            
          
            for (Ball OneBall: Chickens)
                
            {
                g.setColor(OneBall.CurrentColor);
                g.fillOval(OneBall.pos.x,OneBall.pos.y, 50, 50);
                g.drawImage(eggimg,OneBall.eggs.pos.x,OneBall.eggs.pos.y,null);
                g.drawImage(imgsmallchicken,OneBall.pos.x,OneBall.pos.y, null);
                if (SpaceShp.Rocket.pos.distance(OneBall.pos.x, OneBall.pos.y)<=50)
                {
                    Chickens.remove(OneBall);
                    if(Chickens.isEmpty())
                    {
                        lvl++;
                        playlvl(lvl);
                        level.setText("Level "+ lvl);
                    }
                    score++;
                    scoreboard.setText("Score: " + score);
                    break;
                }
                if (OneBall.eggs.pos.distance(SpaceShp.pos.x, SpaceShp.pos.y) <= 90)
                {
                    SpaceShp.health--;
                    health.setText("Health: " + SpaceShp.health);
                    OneBall.eggs.pos.x = 1000;
                    OneBall.eggs.pos.y = 1000;
                    if(SpaceShp.health == 0)
                    {
                        JOptionPane.showMessageDialog(null, "YOU LOSE! \n Score: " + score);
                        
                        System.exit(0);
                    }
                }
                
            }
            
        }
        catch (IOException ex)
        {
           Logger.getLogger(MovingChickens.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    @Override
    public void run() {
    try
    {
        if (counttimer == 3)
            {
                countdown.setText("3");
                Thread.sleep(1000);
                countdown.setText("2");
                Thread.sleep(1000);
                countdown.setText("1");
                Thread.sleep(1000);
                counttimer = 0;
                countdown.setVisible(false);
                level.setVisible(true);
                
            }
        playlvl(1);
    while(true)
    {
        counter++;
        for (Ball OneBall: Chickens)
        {
            if(counter>=80)
            {
                OneBall.eggs.pos.x = OneBall.pos.x;
                OneBall.eggs.pos.y = OneBall.pos.y;
            }
        
            OneBall.move(this.getWidth());
            
            OneBall.eggs.drop();
        }    
    if(counter>=80 )
    {
        counter = 0;
    }
        //y+=10;
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
