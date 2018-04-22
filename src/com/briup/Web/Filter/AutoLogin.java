package com.briup.Web.Filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.briup.Bean.ShopCart;
import com.briup.Bean.User;
import com.briup.Service.Impl.IUserServiceImpl;
import com.briup.common.exception.ServiceException;

@WebFilter("/login.jsp")
public class AutoLogin implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		Cookie[] cookies=req.getCookies();
		if(cookies!=null){
			Map<String, String> map=new HashMap<>();
			for(Cookie c:cookies){
				map.put(c.getName(), c.getValue());
			}
			if(map.containsKey("userid")&&map.containsValue("password")){
				try {
					User us=
					new IUserServiceImpl().login(map.get("userid"), map.get("password"));
				req.getSession().setAttribute("user", us);
				req.getSession().setAttribute("cart", new ShopCart());
				req.getRequestDispatcher("/index.jsp").forward(req, response);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				chain.doFilter(req, response);
			}
		}else{
		chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
