package com.hand.entity;

import java.util.Date;


	public class Address{
	private Short addressId;
	private String address;
	private String address2;
	private String district;
	private Short cityId;
	private String postalCode;
	private String phone;
	private Date lastUpdate;

	public Short getAddressId(){
		return this.addressId;
	}
	public void setAddressId(Short addressId){
		this.addressId=addressId;
	}
	public String getAddress(){
		return this.address;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress2(){
		return this.address2;
	}
	public void setAddress2(String address2){
		this.address2=address2;
	}
	public String getDistrict(){
		return this.district;
	}
	public void setDistrict(String district){
		this.district=district;
	}
	public Short getCityId(){
		return this.cityId;
	}
	public void setCityId(Short cityId){
		this.cityId=cityId;
	}
	public String getPostalCode(){
		return this.postalCode;
	}
	public void setPostalCode(String postalCode){
		this.postalCode=postalCode;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public Date getLastUpdate(){
		return this.lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate){
		this.lastUpdate=lastUpdate;
	}

}