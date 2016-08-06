package com.hand.service;

import java.sql.SQLException;
import java.util.List;

import com.hand.dao.IDAO;

public class BaseService<T> {
	IDAO<T> dao ;
	public BaseService(IDAO<T> dao) {
		this.dao = dao;
	}
	
	//增加  
    public int insert(T t) {
    	try {
			return dao.insert(t);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
    };  
      
    //删除  
   public  int delete(T t){
    	try {
			return dao.delete(t);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
    }
      
    //修改  
    public int update(T t) {
    	try {
			return dao.update(t);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
    }
      
    //得到所有的数据  
   public  List<T> getAll() {
    	try {
			return dao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
      
    //根据条件查询所有的数据  
    public List<T> getByCondition(T t) {
    	try {
			return dao.getByCondition(t);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    };  
      
    //根据ID得到需要的数据  
    public T getByID(String sno){
    	try {
			return dao.getByID(sno);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
	
}
