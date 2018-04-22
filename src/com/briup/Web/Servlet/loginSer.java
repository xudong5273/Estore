package com.briup.Web.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.Bean.ShopCart;
import com.briup.Bean.User;
import com.briup.Service.Impl.IUserServiceImpl;
import com.briup.common.exception.ServiceException;
@WebServlet("/loginSer")
public class loginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String auto=request.getParameter("auto");
		HttpSession session=request.getSession();
		try {
			User user=new IUserServiceImpl().login(userid, password);
			if(auto!=null){
				Cookie cookie=new Cookie("userid", userid);
				cookie.setMaxAge(60*60*24*365);
				Cookie cookie1=new Cookie("password", password);
				cookie1.setMaxAge(60*60*24*365);
				response.addCookie(cookie);
				response.addCookie(cookie1);
			}
			session.setAttribute("user", user);
			session.setAttribute("cart", new ShopCart());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
