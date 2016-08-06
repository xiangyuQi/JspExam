package com.hand.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hand.dao.ActorDAO;
import com.hand.entity.Actor;

public class ActorDAOImpl extends BaseDAO<Actor> implements ActorDAO{
	public int insert(Actor t) throws SQLException {
		String sql = "insert into actor(first_name,last_name,last_update)"
				+ " values(?,?,?)";
		Object objs[] = {t.getFirstName(),t.getLastName(),t.getLastUpdate()};
		return commonUpdate(sql, objs);
	}

	public int delete(Actor t) throws SQLException {
		String sql = "delete from actor where actor_id = ?";
		Object objs[] = {t.getActorId()};
		return commonUpdate(sql, objs);
	}

	public int update(Actor t) throws SQLException {
		String sql = "update actor set first_name = ?,last_name = ?,last_update = ? where actor_id = ?";
		Object objs[] = {t.getFirstName(),t.getLastName(),t.getLastUpdate(),t.getActorId(),};
		return commonUpdate(sql, objs);
	}

	public List<Actor> getAll() throws SQLException {
		String sql = "select actor_id,first_name,last_name,last_update from actor";
		Object objs[] = {};
		return commonQuery(sql, objs);
	}

	public List<Actor> getByCondition(Actor t) throws SQLException {
		String sql = "select actor_id,first_name,last_name,last_update from actor where first_name=? ";
		Object objs[] = {t.getFirstName()};
		return commonQuery(sql, objs);
	}

	public Actor getByID(String sno) throws SQLException {
		String sql = "select actor_id,first_name,last_name,last_update from actor where actor_id = ? ";
		Object objs[] = {sno};
		return commonByID(sql, objs);
	}
	
	public List<Actor> listPage(int pageNo, int pageSize) throws SQLException {
		String sql = "select actor_id,first_name,last_name,last_update from actor limit ?,?";
		Object objs[] = {(pageNo-1)*pageSize,pageSize};
		return commonQuery(sql, objs); 
	}

	@Override
	public Actor wrapper(ResultSet rs) throws SQLException {
		Actor actor = new Actor();
		actor.setActorId(rs.getShort("actor_id"));
		actor.setFirstName(rs.getString("first_name"));
		actor.setLastName(rs.getString("last_name"));
		actor.setLastUpdate(rs.getTimestamp("last_update"));
		return actor;
	}

}
