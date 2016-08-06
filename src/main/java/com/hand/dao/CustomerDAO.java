package com.hand.dao;

import java.sql.SQLException;

public interface CustomerDAO {
	public boolean findByName(String name) throws SQLException;
}
