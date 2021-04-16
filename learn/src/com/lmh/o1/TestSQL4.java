package com.lmh.o1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 批量处理sql语句
 */
public class TestSQL4 {
    public static void main(String[] args) {
        Connection cnn=null;
        Statement stm=null;
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","001019");
           cnn.setAutoCommit(false);
           stm=cnn.createStatement();
           for(int i=1;i<=20000;i++)
           {
               String sql="insert into student (name,pwd) values('lmh"+i+"',666666)";
               stm.addBatch(sql);
           }
           stm.executeBatch();
           cnn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                if(stm!=null)
                    stm.close();
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
