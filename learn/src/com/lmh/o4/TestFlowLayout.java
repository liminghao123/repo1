package com.lmh.o4;

import javax.swing.*;
import  java.awt.*;

public class TestFlowLayout extends JFrame {
    public TestFlowLayout(){
        setTitle("流布局管理");
        setLayout(new FlowLayout(0,10,10));
        setVisible(true);
        Container container=getContentPane();
        setLocation(300,300);
        setSize(500,500);
        for(int i=0;i<10;i++)
        {
            JButton jb=new JButton("button"+i);
            container.add(jb);
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestFlowLayout();
    }
}
