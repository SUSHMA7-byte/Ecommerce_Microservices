package com.cognizant.model;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
	
	private int order_id;
	private int user_id;
	private Date order_date;
	private BigDecimal total_amt;
	private String status;
	
	@Override
	public String toString() {
		return "Orders_Impl [order_id=" + order_id + ", user_id=" + user_id + ", order_date=" + order_date
				+ ", total_amt=" + total_amt + ", status=" + status + "]";
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public BigDecimal getTotal_amt() {
		return total_amt;
	}

	public void setTotal_amt(BigDecimal total_amt) {
		this.total_amt = total_amt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


}
