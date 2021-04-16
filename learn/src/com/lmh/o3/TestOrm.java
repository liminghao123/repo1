package com.lmh.o3;

import com.lmh.o2.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestOrm {
    public static void test01(){
        Connection cnn= JDBCUtil.getMysqlCon();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Object[]> list=null;
        try {
            list=new ArrayList<>();
            ps=cnn.prepareStatement("select name,age,salary from emp where id>?");
            ps.setObject(1,0);
            rs=ps.executeQuery();
            while(rs.next())
            {
                Object[] obj=new Object[3];
                obj[0]=rs.getString(1);
                obj[1]=rs.getInt(2);
                obj[2]=rs.getDouble(3);
                list.add(obj);
            }
            for(Object[] obj:list){
                System.out.println(obj[0]+"-"+obj[1]+"-"+obj[2]);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtil.close(rs,cnn,ps);
        }
    }
    public static void test02(){
        Connection cnn= JDBCUtil.getMysqlCon();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Map<String,Object>> list=null;
        try {
            list=new ArrayList<>();
            ps=cnn.prepareStatement("select name,age,salary from emp where id>?");
            ps.setObject(1,0);
            rs=ps.executeQuery();
            while(rs.next())
            {
                Map<String,Object> map=new HashMap<>();
                map.put("name",rs.getObject(1));
                map.put("age",rs.getObject(2));
                map.put("salary",rs.getObject(3));
                list.add(map);
            }
            for(Map<String,Object> map:list){
                for(String key:map.keySet())
                    System.out.print(key+":"+map.get(key)+"\t");
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtil.close(rs,cnn,ps);
        }
    }
    public static void test03(){
        Connection cnn= JDBCUtil.getMysqlCon();
        PreparedStatement ps=null;
        ResultSet rs=null;
        Map<String,Map<String,Object>> maps=null;
        try {
            maps=new HashMap<>();
            ps=cnn.prepareStatement("select name,age,salary from emp where id>?");
            ps.setObject(1,0);
            rs=ps.executeQuery();
            while(rs.next())
            {
                Map<String,Object> map=new HashMap<>();
                map.put("name",rs.getObject(1));
                map.put("age",rs.getObject(2));
                map.put("salary",rs.getObject(3));
                maps.put(rs.getString(1),map);

            }
            for(String key:maps.keySet()){
                Map<String,Object> map=maps.get(key);
                for(String row:map.keySet()){
                    System.out.print(row+":"+map.get(row)+"\t");
                }
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtil.close(rs,cnn,ps);
        }
    }
    public static void main(String[] args) {
       //test01();
        //test02();
        test03();
    }
}
