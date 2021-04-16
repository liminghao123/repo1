package com.lmh.o4;

import javafx.scene.image.Image;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TestJButton extends JFrame {
    public TestJButton() throws IOException {
        byte[] dates= FileUtils.readFileToByteArray(new File("1.jpg"));
        Icon icon=new ImageIcon(dates);
        setLayout(new GridLayout(3,2,5,5));
        Container container=getContentPane();
        for(int i=0;i<5;i++)
        {
            JButton jb=new JButton("button"+i,icon);
            container.add(jb);
            if(i%2==0)
                jb.setEnabled(false);
        }
        JButton jb=new JButton();
        jb.setMaximumSize(new Dimension(90,30));
        jb.setIcon(icon);
        jb.setHideActionText(true);
        jb.setToolTipText("图片按钮");
        //jb.setBorderPainted(false);
        jb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"弹出对话框");
            }
        });
        container.add(jb);
        setTitle("按钮");
        setLocation(300,300);
        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new TestJButton();
    }
}
