package com.hand.entity;

import java.util.Date;

public class FilmActor {

	private Short actorId;

	private Short filmId;
	
	private Date lastUpdate;
	
	public Short getActorId() {
		return actorId;
	}

	public void setActorId(Short actorId) {
		this.actorId = actorId;
	}

	public Short getFilmId() {
		return filmId;
	}

	public void setFilmId(Short filmId) {
		this.filmId = filmId;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}