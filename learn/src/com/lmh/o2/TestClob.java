package com.lmh.o2;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class TestClob {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection cnn=null;
        PreparedStatement ps=null;
        ResultSet res=null;
        try {
            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","001019");
            ps=cnn.prepareStatement("insert into person (name,txt) values(?,?)");
            ps.setObject(1,"lmh");
            ps.setClob(2,new FileReader(new File("d:/a.txt")));
            ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aabbbc".getBytes(StandardCharsets.UTF_8)))));
            ps.execute();
//            ps=cnn.prepareStatement("select * from person where id=?");
//            ps.setObject(1,219);
//            res=ps.executeQuery();
//            while(res.next())
//            {
//                Clob clob=res.getClob("txt");
//                Reader reader =clob.getCharacterStream();
//                int temp=0;
//                while((temp=reader.read())!=-1)
//                    System.out.print((char)temp);
//            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
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
