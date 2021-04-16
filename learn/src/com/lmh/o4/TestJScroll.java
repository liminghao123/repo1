package com.lmh.o4;

import javax.swing.*;
import java.awt.*;

public class TestJScroll extends  JFrame{
    public TestJScroll(){
        Container container=getContentPane();
        JTextArea jt=new JTextArea(20,50);
        JPanel jp=new JPanel(new GridLayout(1,3,10,10));
        jp.add(jt);
        jp.add(new JButton("按钮"));
        JScrollPane js=new JScrollPane(jp);
        container.add(js);
        setTitle("带滚动条的文字编辑器");
        setVisible(true);
        setLocation(300,300);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestJScroll();
    }
}
