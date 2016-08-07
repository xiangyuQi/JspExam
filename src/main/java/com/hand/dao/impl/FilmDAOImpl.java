package com.hand.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hand.dao.FilmDAO;
import com.hand.entity.Film;
import com.hand.entity.Language;

public class FilmDAOImpl extends BaseDAO<Film> implements FilmDAO{

	public int insert(Film t) throws SQLException {
		String sql = "insert into film (title,description,language_id) "
				+ "values(?,?,?)";
		Object objs []={t.getTitle(),t.getDescription(),t.getLanguage().getLanguageId()} ;
		return commonUpdate(sql, objs);
	}

	public int delete(Film t) throws SQLException {
		String sql = "delete from film where film_id = ?";
		Object objs[] = {t.getFilmId()};
		return commonUpdate(sql, objs);
	}

	public int update(Film t) throws SQLException {
		String sql = "update film set  title = ?,description=?,language_id = ? where film_id = ?";
		Object objs[] ={t.getTitle(),t.getDescription(),t.getLanguage().getLanguageId(),t.getFilmId()};
		return commonUpdate(sql, objs);
	}

	public List<Film> getAll() throws SQLException {
		String sql = "select f.film_id,f.title,f.description,f.language_id ,l.name "
				+ "from film f, language l where f.language_id = l.language_id";
		Object objs[] = {};
		return commonQuery(sql, objs);
	}

	public List<Film> getByCondition(Film t) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Film getByID(String sno) throws SQLException {
		String sql = "select f.film_id,f.title,f.description,f.language_id ,l.name "
				+ "from film f, language l where f.language_id = l.language_id and f.film_id =?";
		Object objs []={sno}; 
		return commonByID(sql, objs);
	}

	public List<Film> listPage(int pageNo, int pageSize) throws SQLException {
		String sql = "select f.film_id,f.title,f.description,f.language_id ,l.name "
				+ "from film f, language l where f.language_id = l.language_id limit ?,?";
		Object objs[] = {(pageNo-1)*pageSize,pageSize};
		return commonQuery(sql, objs); 
	}

	@Override
	public Film wrapper(ResultSet rs) throws SQLException {
		Film f= new Film();
		f.setFilmId(rs.getShort("f.film_id"));
		Language language= new Language();
		language .setLanguageId(rs.getByte("f.language_id"));
		language.setName(rs.getString("l.name"));
		f.setLanguage(language);
		f.setTitle(rs.getString("f.title"));
		f.setDescription(rs.getString("f.description"));
		return f;
	}
	
}
