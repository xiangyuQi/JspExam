package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.CustomerDAO;
import com.hand.util.DBUtil;

public class CustomerDAOImpl implements CustomerDAO{

	public boolean findByName(String name) throws SQLException {
		String sql = "select customer_id  from customer where first_name = ? ";
		Connection conn = DBUtil.getConn();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs  = ps.executeQuery();
		if(rs.next()){
			return true;
		}
		return false ;
	}

	

	
	
}
