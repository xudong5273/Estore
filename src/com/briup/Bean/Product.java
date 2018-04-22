package com.briup.Bean;

import java.util.HashSet;
import java.util.Set;


public class Product {
	private Integer productid;
	private String name;
	private String writer;
	private Double baseprice;
	private String publish;
	private long pages;
	private String description;
	private String images;
	private Category category;
	private Set<Orderline> orderline = new HashSet<>();
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Double getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(Double baseprice) {
		this.baseprice = baseprice;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public long getPages() {
		return pages;
	}
	public void setPages(long pages) {
		this.pages = pages;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Orderline> getOrderline() {
		return orderline;
	}
	public void setOrderline(Set<Orderline> orderline) {
		this.orderline = orderline;
	}
}
