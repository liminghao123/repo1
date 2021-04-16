package com.lmh.o4;

import javax.swing.*;
import java.awt.*;

public class TestGrid {
    public TestGrid(){
        JFrame jf=new JFrame();
        Container container=jf.getContentPane();
        jf.setLocation(300,300);
        jf.setVisible(true);
        jf.setSize(800,700);
        jf.setLayout(new GridLayout(5,6,10,10));
        for(int i=1;i<=30;i++)
            container.add(new JButton("button"+i));
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestGrid();
    }
}
