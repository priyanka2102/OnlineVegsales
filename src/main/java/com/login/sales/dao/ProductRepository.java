package com.login.sales.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.sales.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public Product findByname(String name);
	
	public void deleteById(Long Id);
}
