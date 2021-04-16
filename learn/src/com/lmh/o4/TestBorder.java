package com.lmh.o4;

import javax.swing.*;
import java.awt.*;

public class TestBorder{
    String[] border={BorderLayout.CENTER,BorderLayout.NORTH,BorderLayout.SOUTH,BorderLayout.WEST,BorderLayout.EAST};
    String[] buttonName={"center","north","south","west","east"};
    public TestBorder(){
        JFrame jf=new JFrame();
        Container container =jf.getContentPane();
        jf.setLayout(new BorderLayout());
        jf.setLocation(300,300);
        jf.setVisible(true);
        jf.setSize(500,500);
        for(int i=0;i<border.length;i++)
        {
            container.add(border[i],new JButton(buttonName[i]));
        }
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestBorder();
    }
}
