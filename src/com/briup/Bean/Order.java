package com.briup.Bean;

import java.util.Set;

public class Order {
	private Integer orderid;
	private String name;
	private Integer finished;
	private Double cost;
	private String cardno;//00000002
	private User user;
	private OrderStatus status;//1
	private Payway payway;//
	private Set<Orderline> orderlines;
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFinished() {
		return finished;
	}
	public void setFinished(Integer finished) {
		this.finished = finished;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Payway getPayway() {
		return payway;
	}
	public void setPayway(Payway payway) {
		this.payway = payway;
	}
	public Set<Orderline> getOrderlines() {
		return orderlines;
	}
	public void setOrderlines(Set<Orderline> orderlines) {
		this.orderlines = orderlines;
	} 
}
