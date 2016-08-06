package com.hand.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hand.dao.LanguageDao;
import com.hand.entity.Language;

public class LanguageDaoImpl extends BaseDAO<Language> implements LanguageDao {

	public int insert(Language t) throws SQLException {
		String sql ="insert into language(name,last_update) values(?,?)";
		Object objs[] ={t.getName(),t.getLastUpdate()};
		return commonUpdate(sql, objs);
	}

	public int delete(Language t) throws SQLException {
		String sql = "delete from language where language_id = ?";
		Object objs[] ={t.getLanguageId()};
		return commonUpdate(sql, objs);
	}

	public int update(Language t) throws SQLException {
		String sql = "update language set name=? ,last_update = ? where language_id = ?";
		Object objs[] = {t.getName(),t.getLastUpdate(),t.getLanguageId()};
		return commonUpdate(sql, objs);
	}

	public List<Language> getAll() throws SQLException {
		String sql = "select language_id,name,last_update from language";
		Object objs []  = {};
		return commonQuery(sql, objs);
	}

	public List<Language> getByCondition(Language t) throws SQLException {
		return null;
	}

	public Language getByID(String sno) throws SQLException {
		String sql = " select language_id,name,last_update from language where language_id = ?";
		Object objs [] = {sno};
		return commonByID(sql, objs);
	}

	@Override
	public Language wrapper(ResultSet rs) throws SQLException {
		Language language = new Language();
		language.setLanguageId(rs.getByte("language_id"));
		language.setName(rs.getString("name"));
		return language;
	}
	
}
