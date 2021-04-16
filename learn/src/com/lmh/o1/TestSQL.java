package com.lmh.o1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSQL {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection cnn= null;
        Statement stm=null;
        try {
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","001019");
            System.out.println(cnn);
            stm=cnn.createStatement();
            String name="wlx";
            String str="insert into person (id,name,age,salary) values(6,'"+name+"',18,0)";
            stm.execute(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (stm != null)
                    stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (cnn != null)
                    cnn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
