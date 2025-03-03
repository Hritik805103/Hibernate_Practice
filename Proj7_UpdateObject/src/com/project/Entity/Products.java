package com.project.Entity;

import java.io.Serializable;

//Entity/Persistence/Domain/Model Class
public class Products implements Serializable {

	private Integer pid;
	private String pname;
	private Float price;
	private Integer qty;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
//	Getters and Setters

	
}
