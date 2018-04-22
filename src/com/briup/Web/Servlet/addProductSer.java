package com.briup.Web.Servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.Bean.Product;
import com.briup.Bean.ShopCart;
@WebServlet("/user/addProductSer")
public class addProductSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("product_id");
		ServletContext sc=request.getServletContext();
		Map<Integer, Product> map =
				(Map<Integer, Product>) sc.getAttribute("map");
		Product pro=map.get(Integer.parseInt(id));
		HttpSession session=request.getSession();
		ShopCart cart=(ShopCart) session.getAttribute("cart");
		try {
			cart.addProduct(pro);
			//request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
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
