package com.product.MapstructUse.pro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
	
	@Autowired
	ProductsRepo productsRepo;
	
	
	public List<Products> getall()
	{
		return productsRepo.findAll();
	}
	
	public Optional<Products> findByid(long id)
	{
		return productsRepo.findById(id);
	}
	
	 public Products save(Products stock) {
	        return productsRepo.save(stock);
	    }

	    public void deleteById(Long id) {
	    	productsRepo.deleteById(id);
	    }

}
