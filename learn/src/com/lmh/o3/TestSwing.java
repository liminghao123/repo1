package com.lmh.o3;

import javax.swing.*;
import java.awt.*;

public class TestSwing extends JFrame {
    public TestSwing(){
        setLayout(null);
        Container container=getContentPane();
        slove(this);
        JButton b1=new JButton("第一个按钮");
        JButton b2=new JButton("第二个按钮");
        b1.setBounds(100,100,200,200);
        b2.setBounds(300,300,100,100);
        container.add(b1);
        container.add(b2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void slove(JFrame jf){
        jf.setSize(500,500);
        jf.setVisible(true);
        jf.setLocation(300,300);
    }
    public static void main(String[] args) {
        new TestSwing();
    }
}
