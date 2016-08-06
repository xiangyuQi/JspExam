package com.hand.dao;


import java.sql.SQLException;
import java.util.List;

import com.hand.entity.Actor;

public interface ActorDAO extends IDAO<Actor> {
	
    public List<Actor> listPage(int pageNo, int pageSize)throws SQLException;
}
