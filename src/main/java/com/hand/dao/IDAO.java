package com.hand.dao;

import java.sql.SQLException;
import java.util.List;


public interface IDAO<T>  
{  
    //增加  
    int insert(T t) throws SQLException;  
      
    //删除  
    int delete(T t) throws SQLException;  
      
    //修改  
    int update(T t) throws SQLException;  
      
    //得到所有的数据  
    List<T> getAll() throws SQLException;  
      
    //根据条件查询所有的数据  
    List<T> getByCondition(T t) throws SQLException;  
      
    //根据ID得到需要的数据  
    T getByID(String sno) throws SQLException;  
    
}  
