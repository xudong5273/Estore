package com.briup.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.briup.Bean.Order;
import com.briup.Bean.Orderline;
import com.briup.Bean.Payway;
import com.briup.Bean.User;
import com.briup.Dao.IOrderDao;
import com.briup.Service.IOrderService;
import com.briup.common.exception.ServiceException;
import com.briup.common.util.MyBatisSqlSessionFactory;

public class IOrderServiceImpl implements IOrderService{

	@Override
	public List listOrdersOfUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		SqlSession session =MyBatisSqlSessionFactory.openSession(true);
		IOrderDao dao=session.getMapper(IOrderDao.class);
		List<Order> list=dao.getAllOrders(user.getUserid());
		return list;
	}

	@Override
	public void removeOrder(Integer orderid) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrder(Order order) throws ServiceException {
		// TODO Auto-generated method stub
		SqlSession session =MyBatisSqlSessionFactory.openSession(true);
		IOrderDao dao=session.getMapper(IOrderDao.class);
		dao.saveOrder(order);
		Set<Orderline> orderlines=order.getOrderlines();
		for(Orderline line:orderlines){
			line.setOrder(order);
			dao.saveOrderLine(line);
		}
	}

	@Override
	public Map listAllPayways() throws ServiceException {
		// TODO Auto-generated method stub
		SqlSession session=MyBatisSqlSessionFactory.openSession();
		IOrderDao dao=session.getMapper(IOrderDao.class);
		List<Payway> list=dao.getAllPayways();
		Map<Integer, Payway> map=new HashMap<>();
		if(list.size()>0){
		for(Payway p:list){
			System.out.println(p);
			map.put(p.getPaywayid(), p);
		}
		}
		return map;
	}

	@Override
	public Order listOrderByOrderid(Integer orderid) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
