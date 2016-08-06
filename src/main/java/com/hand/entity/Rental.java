package com.hand.entity;

import java.util.Date;

public class Rental{
	private Integer rentalId;
	private Date rentalDate;
	private Integer inventoryId;
	private Short customerId;
	private Date returnDate;
	private Byte staffId;
	private Date lastUpdate;

	public Integer getRentalId(){
		return this.rentalId;
	}
	public void setRentalId(Integer rentalId){
		this.rentalId=rentalId;
	}
	public Date getRentalDate(){
		return this.rentalDate;
	}
	public void setRentalDate(Date rentalDate){
		this.rentalDate=rentalDate;
	}
	public Integer getInventoryId(){
		return this.inventoryId;
	}
	public void setInventoryId(Integer inventoryId){
		this.inventoryId=inventoryId;
	}
	public Short getCustomerId(){
		return this.customerId;
	}
	public void setCustomerId(Short customerId){
		this.customerId=customerId;
	}
	public Date getReturnDate(){
		return this.returnDate;
	}
	public void setReturnDate(Date returnDate){
		this.returnDate=returnDate;
	}
	public Byte getStaffId(){
		return this.staffId;
	}
	public void setStaffId(Byte staffId){
		this.staffId=staffId;
	}
	public Date getLastUpdate(){
		return this.lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate){
		this.lastUpdate=lastUpdate;
	}

}