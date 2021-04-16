package com.lmh.o1;

import java.sql.*;

/**
 * 查询
 */
public class TestSQL3 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection cnn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","001019");
            String sql="select id,name,salary from person where id>?";
            ps=cnn.prepareStatement(sql);
            ps.setObject(1,2);
            rs=ps.executeQuery();
            while(rs.next())
            {
                System.out.println("id:"+rs.getInt(1)+"--"+"name:"+rs.getString(2)+"--"+"salary:"+rs.getInt(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                if(rs!=null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
