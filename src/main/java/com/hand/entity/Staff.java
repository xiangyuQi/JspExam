package com.hand.entity;

import java.util.Date;

/**
	*	*@author yangsj
	*/

	public class Staff{
	private Byte staffId;
	private String firstName;
	private String lastName;
	private Short addressId;
	private byte[] picture;
	private String email;
	private Byte storeId;
	private Byte active;
	private String username;
	private String password;
	private Date lastUpdate;

	public Byte getStaffId(){
		return this.staffId;
	}
	public void setStaffId(Byte staffId){
		this.staffId=staffId;
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
	public Short getAddressId(){
		return this.addressId;
	}
	public void setAddressId(Short addressId){
		this.addressId=addressId;
	}
	public byte[] getPicture(){
		return this.picture;
	}
	public void setPicture(byte[] picture){
		this.picture=picture;
	}
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public Byte getStoreId(){
		return this.storeId;
	}
	public void setStoreId(Byte storeId){
		this.storeId=storeId;
	}
	public Byte getActive(){
		return this.active;
	}
	public void setActive(Byte active){
		this.active=active;
	}
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public Date getLastUpdate(){
		return this.lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate){
		this.lastUpdate=lastUpdate;
	}

}