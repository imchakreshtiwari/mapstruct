package com.product.MapstructUse.pro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductMapperImpl implements ProductMapper  {

	@Override
	
public ProductDTO toProductDTO(Products products)
	{
		if(products == null)
		{
			return null;
		}
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName(products.getName());
		productDTO.setDescription(products.getDescription());
		productDTO.setPrice(products.getPrice());
		return productDTO;
	}

	@Override
	public List<ProductDTO> toProductDTOs(List<Products> products) {
		
		if(products == null)
		{
			return null;
		}
		List<ProductDTO> listproductdto = new ArrayList<ProductDTO>();
		for(Products   eachproducts : products)
		{
			listproductdto.add(toProductDTO(eachproducts));
		}
		return listproductdto;
	}

	@Override
	public Products toProduct(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		if(productDTO == null)
		{
			return null;
		}
		Products products = new Products();
		products.setName(productDTO.getName());
		products.setPrice(productDTO.getPrice());
		products.setDescription(productDTO.getDescription()); 
		return products;
	}
}
