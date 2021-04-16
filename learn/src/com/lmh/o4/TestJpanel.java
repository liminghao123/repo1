package com.lmh.o4;

import javax.swing.*;
import java.awt.*;

public class TestJpanel {
    public TestJpanel(){
        JFrame jf=new JFrame();
        jf.setTitle("面板");
        jf.setLocation(300,300);
        jf.setSize(500,500);
        jf.setVisible(true);
        Container container=jf.getContentPane();
        jf.setLayout(new GridLayout(2,1,10,10));
        JPanel jp1=new JPanel(new GridLayout(1,3,10,10));
        JPanel jp2=new JPanel(new GridLayout(1,2,10,10));
        JPanel jp3=new JPanel(new GridLayout(1,2,10,10));
        JPanel jp4=new JPanel(new GridLayout(2,1,10,10));
        jp1.add(new JButton("1"));
        jp1.add(new JButton("2"));
        jp1.add(new JButton("3"));
        jp2.add(new JButton("4"));
        jp2.add(new JButton("5"));
        jp3.add(new JButton("6"));
        jp3.add(new JButton("7"));
        jp4.add(new JButton("8"));
        jp4.add(new JButton("9"));
        container.add(jp1);
        container.add(jp2);
        container.add(jp3);
        container.add(jp4);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestJpanel();
    }
}
