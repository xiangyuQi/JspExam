package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.util.DBUtil;

public abstract class BaseDAO<T>  
{  
      /** 
     *  
     * 提供对数据库的增删改的共同的操作 
     * @param sql  增删改的SQL语句 
     * @param objs 对SQL语句中的占位符赋值 
     * @return  受影响的行数 
     * @throws SQLException  
     * @see [类、类#方法、类#成员] 
     */  
  public int commonUpdate(String sql, Object[] objs) throws SQLException  
    {  
        //标识增删改受影响的行数，如果为0，表示增删改不成功  
        int flag = 0;  
          
        //1.得到连接  
        Connection con = DBUtil.getConn();  
          
        //2.得到PreparedStatement对象  
        PreparedStatement ps = con.prepareStatement(sql);  
         
        //3.根据PreparedStatement对象，对占位符赋值  
        for(int i = 0; i < objs.length; i++)  
        {  
            ps.setObject(i + 1, objs[i]);  
        }  
          
        //4.执行增删改的操作  
        flag = ps.executeUpdate();  
          
        //5.关闭相关对象  
        DBUtil.closePreparedStatement(ps);  
        DBUtil.closeConn(con);  
          
        //返回受影响的行数  
        return flag;  
    }  
      
    /** 
     *  
     * 提供对查询所有，及按条件进行查询，操作数据库的共同方法 
     * @param sql  查询的sql语句 
     * @param objs 为sql语句的占位符符纸的数组 
     * @return 包含了数据bean的集合对象 
     * @throws SQLException  
     * @see [类、类#方法、类#成员] 
     */  
    public List<T> commonQuery(String sql, Object[] objs) throws SQLException  
    {  
        //1.实例化一个List对象，且该容器只能存放T类型对象  
        List<T> lst = new ArrayList<T>();  
          
        //2.得到数据库连接  
        Connection con = DBUtil.getConn();  
          
        //3.得到PreparedStatement对象  
        PreparedStatement ps = con.prepareStatement(sql);  
          
        //4.为占位符赋值  
        for(int i = 0; i < objs.length; i++)  
        {  
            ps.setObject(i+1, objs[i]);  
        }  
          
        //5.执行查询，并将查询结果放在结果集中  
        ResultSet rs = ps.executeQuery();  
          
        //6.将查询的结果的一行信息，作为一个数据bean，存放入集合中  
        while(rs.next())  
        {  
            lst.add(wrapper(rs));  
        }  
          
        //7.关闭相关对象  
        DBUtil.closeResultSet(rs);  
        DBUtil.closePreparedStatement(ps);  
        DBUtil.closeConn(con);  
          
        //8.返回集合对象  
        return lst;  
    }  
      
    /** 
     *  
     * 根据ID，查询信息的共同方法 
     * @param sql 查询语句 
     * @param objs 为查询语句的占位符赋值的数组 
     * @return 查询语句后，当前的数据bean对象 
     * @throws SQLException  
     * @see [类、类#方法、类#成员] 
     */  
    public T commonByID(String sql, Object[] objs) throws SQLException  
    {  
        T t = null;  
          
        //1.得到连接  
        Connection con = DBUtil.getConn();  
          
        //2.得到PreparedStatement对象  
        PreparedStatement ps = con.prepareStatement(sql);  
          
        //3.为占位符赋值  
        for(int i = 0; i < objs.length; i++)  
        {  
            ps.setObject(i+1, objs[i]);  
        }  
          
        //4.执行查询，并将结果赋值给结果集对象  
        ResultSet rs = ps.executeQuery();  
          
        //5.将查询的结果的一行信息，作为一个数据bean  
        while(rs.next())  
        {  
            t = wrapper(rs);  
        }  
          
        //6.关闭相关对象  
        DBUtil.closeResultSet(rs);  
        DBUtil.closePreparedStatement(ps);  
        DBUtil.closeConn(con);  
          
        //7.返回根据ID得到的数据bean对象  
        return t;  
    }  
      
      
      
    /** 
     * 该方法为抽象方法。因为目前不知道具体是那个数据BEAN使用该类中的查询方法， 
     * 所以，定义一个抽象的方法，该方法让实现具体数据bean的类去实现 
     * 该方法功能，是将当前指针指向的行的信息，封装成一个数据bean类的对象，并返回该 
     * 对象 
     * @param rs 表示数据集合中，当前指针指向的行 
     * @return 返回数据bean的对象 
     * @see [类、类#方法、类#成员] 
     */  
    public abstract T wrapper(ResultSet rs) throws SQLException;  
}  
