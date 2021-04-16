package com.lmh.o2;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {
        Connection cnn=JDBCUtil.getMysqlCon();
        PreparedStatement ps=null;
        try {
            ps=cnn.prepareStatement("insert into person (name,txt) values(?,?)");
            ps.setObject(1,"lmh");
            ps.setClob(2,new FileReader(new File("d:/a.txt")));
            ps.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtil.close(cnn,ps);
        }

    }
}
