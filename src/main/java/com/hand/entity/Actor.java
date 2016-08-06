package com.hand.entity;

import java.util.Date;



	public class Actor{
	private Short actorId;
	private String firstName;
	private String lastName;
	private Date lastUpdate;

	public Short getActorId(){
		return this.actorId;
	}
	public void setActorId(Short actorId){
		this.actorId=actorId;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public String getLastName(){
		return this.lastName;
	}
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public Date getLastUpdate(){
		return this.lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate){
		this.lastUpdate=lastUpdate;
	}
	
}