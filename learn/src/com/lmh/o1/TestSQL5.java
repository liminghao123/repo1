package com.lmh.o1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestSQL5 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection cnn=null;
        PreparedStatement ps1=null;
        PreparedStatement ps2=null;

        try {
            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","001019");
            //cnn.setAutoCommit(false);
            ps1=cnn.prepareStatement("insert into student (name,pwd) values(?,?)");
            ps1.setObject(1,"lmh");
            ps1.setObject(2,"666666");
            ps1.execute();
            System.out.println("lmh");

            ps2=cnn.prepareStatement("insert into student (name,pwd) values(?,?,?)");
            ps2.setObject(1,"wlx");
            ps2.setObject(2,"666666");
            ps2.execute();
            System.out.println("wlx");

            //cnn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                cnn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally{
            try {
                if(ps1!=null)
                    ps1.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(ps2!=null)
                    ps2.close();
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
