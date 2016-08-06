package com.hand.service;

import java.sql.SQLException;
import java.util.List;

import com.hand.dao.FilmDAO;
import com.hand.dao.impl.FilmDAOImpl;
import com.hand.entity.Film;

public class FilmService extends BaseService<Film> {

private static FilmDAO dao = new FilmDAOImpl();
	
	public FilmService() {
		super(dao);
	}
	   public  List<Film> listPage(int pageNo, int pageSize) {
		   	try {
				return dao.listPage(pageNo, pageSize);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	   }
	
}
