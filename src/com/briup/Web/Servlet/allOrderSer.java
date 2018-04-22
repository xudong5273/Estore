package com.briup.Web.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.Bean.Order;
import com.briup.Bean.User;
import com.briup.Service.Impl.IOrderServiceImpl;

@WebServlet("/allOrderSer")
public class allOrderSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Order> list=null;
		try {
			list = new IOrderServiceImpl().listOrdersOfUser(user);
			session.setAttribute("orders",list);
			request.getRequestDispatcher("/user/order.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
