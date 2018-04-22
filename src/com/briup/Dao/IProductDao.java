package com.briup.Dao;

import java.util.List;

import com.briup.Bean.Product;

public interface IProductDao {
	//查询所有的产品
	List<Product> allListProduct();
}
