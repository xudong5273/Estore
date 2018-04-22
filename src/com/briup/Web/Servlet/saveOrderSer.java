package com.briup.Web.Servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.Bean.Order;
import com.briup.Bean.OrderStatus;
import com.briup.Bean.Orderline;
import com.briup.Bean.Payway;
import com.briup.Bean.ShopCart;
import com.briup.Bean.User;
import com.briup.Service.Impl.IOrderServiceImpl;
@WebServlet("/user/saveOrderSer")
public class saveOrderSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String payway=request.getParameter("payway");
		HttpSession session=request.getSession();
		ServletContext sc=request.getServletContext();
		Map<Integer, Payway> pays=
				(Map<Integer, Payway>) sc.getAttribute("pays");
		Payway pay=pays.get(Integer.parseInt(payway));
		User user=(User) session.getAttribute("user");
		//去数据库查询状态对象
		OrderStatus status=new OrderStatus();
		status.setStatusid(1);
		ShopCart cart=(ShopCart) session.getAttribute("cart");
		Set<Orderline> orderlines=new HashSet<>();
		try {
			Iterator<Orderline> iter=cart.getOrderlines();
			while(iter.hasNext()){
				orderlines.add(iter.next());
			}
			Order order=new Order();
			order.setCardno("00001");
			order.setCost(cart.getTotalPrice().doubleValue());
			order.setFinished(1);
			order.setName("Estore");
			order.setOrderlines(orderlines);
			order.setPayway(pay);
			order.setStatus(status);
			order.setUser(user);
			new IOrderServiceImpl().saveOrder(order);
			cart.removeAllProducts();
			request.getRequestDispatcher("/index.jsp")
				.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
