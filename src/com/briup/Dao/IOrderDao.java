package com.briup.Dao;

import java.util.List;

import com.briup.Bean.Order;
import com.briup.Bean.Orderline;
import com.briup.Bean.Payway;

public interface IOrderDao {
	List<Payway> getAllPayways();
	void saveOrder(Order order);
	void saveOrderLine(Orderline orderline);
	List<Order> getAllOrders(String userid);
}
