/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */
public class Ch8Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
  
        
        JFrame jf=new JFrame();
        jf.setSize(1000, 600);
        
        MovingChickens mc=new MovingChickens();
        
    
        
        
        jf.add(mc,BorderLayout.CENTER);
        mc.setFocusable(true);
        Thread t1=new Thread(mc);
        t1.start();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
 
        
        
        
    }
    
}
