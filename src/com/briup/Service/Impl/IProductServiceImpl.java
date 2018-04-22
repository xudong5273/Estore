package com.briup.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.briup.Bean.Product;
import com.briup.Dao.IProductDao;
import com.briup.Service.IProductService;
import com.briup.common.exception.ServiceException;
import com.briup.common.util.MyBatisSqlSessionFactory;

public class IProductServiceImpl implements IProductService{

	@Override
	public Map listAllProducts() throws ServiceException {
		// TODO Auto-generated method stub
		SqlSession session=MyBatisSqlSessionFactory.openSession();
		IProductDao dao=session.getMapper(IProductDao.class);
		List<Product> list=dao.allListProduct();
		Map<Integer, Product> map=new HashMap<>();
		if(list.size()>0){
			for(Product p:list){
				map.put(p.getProductid(), p);
			}
		}
		return map;
	}

	@Override
	public Product getProductByProductid(Integer productid) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
