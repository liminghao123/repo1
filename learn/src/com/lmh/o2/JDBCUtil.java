package com.lmh.o2;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    public static Connection getMysqlCon(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","001019");
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
    public static void close(ResultSet res ,Connection cnn,PreparedStatement ps){
        try {
            if(res!=null)
                res.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
        public static void close(Connection cnn,PreparedStatement ps){
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (cnn != null)
                    cnn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
}
