package com.lmh.o2;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class TestBlob {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection cnn=null;
        PreparedStatement ps=null;
        ResultSet res=null;
        InputStream is=null;
        OutputStream os=null;
        try {
            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","001019");
            ps=cnn.prepareStatement("insert into person (name,image) values(?,?)");
            ps.setObject(1,"lmh");
            ps.setBlob(2,new FileInputStream(new File("C:\\Users\\23877\\Pictures\\Saved Pictures\\309359.jpg")));
            ps.execute();
            ps=cnn.prepareStatement("select * from person where id=?");
            ps.setObject(1,222);
            res=ps.executeQuery();
            while(res.next())
            {
                Blob b=res.getBlob("image");
                is=b.getBinaryStream();
                os=new FileOutputStream(new File("a.jpg"));
                byte[] dates=new byte[1024];
                int len=-1;
                while((len=is.read(dates))!=-1)
                {
                   os.write(dates,0,len);
                }
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally{
            try {
                if(is!=null)
                    is.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
            try {
                if(os!=null)
                    os.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
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
    }
}
