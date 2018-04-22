package com.briup.Web.Listener;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.Bean.Payway;
import com.briup.Bean.Product;
import com.briup.Service.Impl.IOrderServiceImpl;
import com.briup.Service.Impl.IProductServiceImpl;
import com.briup.common.exception.ServiceException;
@WebListener
public class ApplicationListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ServletContext sc=arg0.getServletContext();
    	try {
			Map<Integer, Product> map=
					new IProductServiceImpl().listAllProducts();
			sc.setAttribute("map", map);
			//获取所有的支付方式
			Map<Integer, Payway> pays=
					new IOrderServiceImpl().listAllPayways();
			sc.setAttribute("pays", pays);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}





