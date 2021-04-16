package com.lmh.o1;

import java.sql.*;

public class TestSQL2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection cnn= null;
        PreparedStatement ps=null;
        try {
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","001019");
            String sql="insert into person (name,age,time) values(?,?,?)";
            ps=cnn.prepareStatement(sql);
            ps.setObject(1,"lmh");
            ps.setObject(2,19);
            ps.setObject(3,new Date(System.currentTimeMillis()));
            ps.execute();

            sql="insert into person (name,salary,time) values(?,?,?)";
            ps=cnn.prepareStatement(sql);
            ps.setObject(1,"love");
            ps.setObject(2,1999999);
            ps.setObject(3,new Date(System.currentTimeMillis()));
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(cnn!=null)
                    cnn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }
}
