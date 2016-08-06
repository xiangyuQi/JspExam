package com.hand.entity;

import java.util.Date;

	public class Category{
	private Byte categoryId;
	private String name;
	private Date lastUpdate;

	public Byte getCategoryId(){
		return this.categoryId;
	}
	public void setCategoryId(Byte categoryId){
		this.categoryId=categoryId;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public Date getLastUpdate(){
		return this.lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate){
		this.lastUpdate=lastUpdate;
	}

}