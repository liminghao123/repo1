package com.lmh.o3;

import com.lmh.o2.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestOrm2 {
    public static void main(String[] args) {
        Connection cnn= JDBCUtil.getMysqlCon();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Emp> list=null;
        try {
            list=new ArrayList<>();
            ps=cnn.prepareStatement("select name,age,salary from emp where id>?");
            ps.setObject(1,0);
            rs=ps.executeQuery();
            while(rs.next())
            {
                Emp emp=new Emp(rs.getString(1),rs.getInt(2),rs.getDouble(3));
                list.add(emp);
            }
            for(Emp emp:list) {
                System.out.println(emp.getName()+"-"+emp.getAge()+"-"+emp.getSalary());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtil.close(rs,cnn,ps);
        }
    }
    }
