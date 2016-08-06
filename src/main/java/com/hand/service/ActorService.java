package com.hand.service;

import java.sql.SQLException;
import java.util.List;

import com.hand.dao.ActorDAO;
import com.hand.dao.impl.ActorDAOImpl;
import com.hand.entity.Actor;

public class ActorService extends BaseService<Actor> {
	
	private static ActorDAO dao = new ActorDAOImpl();
	
	public ActorService() {
		super(dao);
	}
	   public  List<Actor> listPage(int pageNo, int pageSize) {
		   	try {
				return dao.listPage(pageNo, pageSize);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
	   }

}
