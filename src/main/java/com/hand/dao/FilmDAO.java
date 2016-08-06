package com.hand.dao;

import java.sql.SQLException;
import java.util.List;

import com.hand.entity.Film;

public interface FilmDAO extends IDAO<Film>{
	
	 public List<Film> listPage(int pageNo, int pageSize)throws SQLException;

}
