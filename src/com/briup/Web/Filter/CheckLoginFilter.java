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
import javax.servlet.http.HttpSession;

import com.briup.Bean.ShopCart;
import com.briup.Bean.User;
import com.briup.Service.Impl.IUserServiceImpl;
import com.briup.common.exception.ServiceException;

/**
 * 拦截所有/user开头的资源，
 * 原因：所有／user开头的请求资源都是需要用户先登录 的
 */
@WebFilter("/user/*")
public class CheckLoginFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpSession session=req.getSession();
		User user=(User) session.getAttribute("user");
		if(user!=null){
			chain.doFilter(request, response);
		}else{
			Cookie[] cookies=req.getCookies();
			if(cookies!=null){
				Map<String, String> map=new HashMap<>();
				for(Cookie c:cookies){
					map.put(c.getName(), c.getValue());
				}
				if(map.containsKey("userid")&&map.containsKey("password")){
					try {
						User us=new IUserServiceImpl().login(map.get("userid"), map.get("password"));
						req.getSession().setAttribute("user", us);
						req.getSession().setAttribute("cart", new ShopCart());
					} catch (ServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//req.setAttribute("msg", "亲!请登录");
						req.getRequestDispatcher("/login.jsp").forward(req, response);
					}
				}else{
					//req.setAttribute("msg", "亲!请登录");
					req.getRequestDispatcher("/login.jsp").forward(req, response);
				}
			}else{
				req.setAttribute("msg", "亲!请登录");
				req.getRequestDispatcher("/login.jsp").forward(req, response);
			}
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
