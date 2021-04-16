package com.lmh.o2;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Random;

public class Learn{

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection cnn=null;
        PreparedStatement ps=null;

        try {
            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","001019");
//            ps=cnn.prepareStatement("insert into person (name,age,salary,time,endtime) values(?,?,?,?,?)");
//            ps.setObject(1,"lmh");
//            ps.setObject(2,19);
//            ps.setObject(3,99999999);
//            Date date=new Date(System.currentTimeMillis());
//            ps.setObject(4,date);
//
//            long len=new Random().nextInt(1000000000);
//            for(int i=1;i<=1000000;i++)
//                    len+=10000000;
//           Date d=new Date(System.currentTimeMillis()+len);
//            ps.setObject(5,d);
//            ps.execute();
            ps=cnn.prepareStatement("delete from person where id<?");
            ps.setObject(1,216);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                if(ps!=null)
                    ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(cnn!=null)
                    cnn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
