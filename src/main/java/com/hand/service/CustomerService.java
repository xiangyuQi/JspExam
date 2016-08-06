package com.hand.service;

import java.sql.SQLException;

import com.hand.dao.CustomerDAO;
import com.hand.dao.impl.CustomerDAOImpl;

public class CustomerService {
	private CustomerDAO dao = new CustomerDAOImpl();
	
	public boolean existUser(String name){
		try {
			return dao.findByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
