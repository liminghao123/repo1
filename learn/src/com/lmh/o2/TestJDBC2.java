package com.lmh.o2;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestJDBC2 {
    public static long solve(String date)
    {
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return df.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
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
            ps=cnn.prepareStatement("select * from student where startTime>? and endTime<? order by startTime");
            ps.setObject(1,new Timestamp(solve("2021-02-25 10:20:30")));
            ps.setObject(2,new Timestamp(solve("2021-02-27 00:20:30")));
            res=ps.executeQuery();
            while(res.next())
            {
                System.out.println("name:"+res.getString("name")+" StartTime:"+ res.getTimestamp("startTime")+" endTime:"
                +res.getTimestamp("endTime"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
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
