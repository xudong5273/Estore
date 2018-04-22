package com.briup.Web.Servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.Bean.Product;

@WebServlet("/productDetailSer")
public class productDetailSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("product_id");
		ServletContext sc=request.getServletContext();
		Map<Integer, Product> map=
				(Map<Integer, Product>) sc.getAttribute("map");
		Product pro=map.get(Integer.parseInt(id));
		request.setAttribute("pro", pro);
		request.getRequestDispatcher("/productDetail.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
