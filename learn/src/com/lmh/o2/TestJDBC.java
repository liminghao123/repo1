package com.lmh.o2;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.*;
import java.util.Random;

public class TestJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection cnn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","001019");
            ps=cnn.prepareStatement("insert into student (name,pwd,startTime,endTime) values(?,?,?,?)");
            for(int i=1;i<=100;i++)
            {
                ps.setObject(1,"lmh"+i);
                ps.setObject(2,666666);
                int len=new Random().nextInt(1000000000)+1000000000;
                Timestamp stamp= new Timestamp(System.currentTimeMillis()+len);
                ps.setObject(3,stamp);
                ps.setObject(4,stamp);
                ps.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
