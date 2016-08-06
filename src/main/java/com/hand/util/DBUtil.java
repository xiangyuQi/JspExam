package com.hand.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil {
	private static String url;
	private static String username;
	private static String password;
	private static String driver;

	static{
		Properties properties = new Properties();
		try {

			InputStream in = DBUtil.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			//System.out.println(DBFactory.class.getClassLoader().toString());
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn()  {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConn(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closePreparedStatement(PreparedStatement ps)  
	{  
		try {  
			ps.close();  
		}  
		catch (SQLException e) {  
			e.printStackTrace();  
		}         
	}  
	public static void closeResultSet(ResultSet rs)  
	{  
		try  {  
			rs.close();  
		}  
		catch (SQLException e)  {  
			e.printStackTrace();  
		}         
	}  
}
