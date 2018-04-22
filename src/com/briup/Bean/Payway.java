package com.briup.Bean;

import java.util.HashSet;
import java.util.Set;

public class Payway {
	private Integer paywayid;
	private String paystyle;
	private Set<Order> orders=new HashSet<>();
	public Integer getPaywayid() {
		return paywayid;
	}
	public void setPaywayid(Integer paywayid) {
		this.paywayid = paywayid;
	}
	public String getPaystyle() {
		return paystyle;
	}
	public void setPaystyle(String paystyle) {
		this.paystyle = paystyle;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
