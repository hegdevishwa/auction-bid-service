package com.sapient.auction.bidservice.domain.model;

public enum ItemCategories {
	MOBILE("Mobile Phone"), HOMEAPPLIANCE("Home appliance"), TWOWHEELER("Two wheeler"), FOURWHEELER("Four wheeler");   
	private String value;  
	private ItemCategories(String value){  
		this.setValue(value);  
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}  
}
