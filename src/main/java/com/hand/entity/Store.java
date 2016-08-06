package com.hand.entity;

import java.sql.Timestamp;


	public class Store{
	private Byte storeId;
	private Byte managerStaffId;
	private Short addressId;
	private Timestamp lastUpdate;

	public Byte getStoreId(){
		return this.storeId;
	}
	public void setStoreId(Byte storeId){
		this.storeId=storeId;
	}
	public Short getAddressId(){
		return this.addressId;
	}
	public void setAddressId(Short addressId){
		this.addressId=addressId;
	}
	public Timestamp getLastUpdate(){
		return this.lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate){
		this.lastUpdate=lastUpdate;
	}
	public Byte getManagerStaffId() {
		return managerStaffId;
	}
	public void setManagerStaffId(Byte managerStaffId) {
		this.managerStaffId = managerStaffId;
	}
	
}