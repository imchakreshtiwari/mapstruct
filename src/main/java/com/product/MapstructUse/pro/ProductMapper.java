package com.product.MapstructUse.pro;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
	
	ProductDTO toProductDTO(Products products);
	
    List<ProductDTO> toProductDTOs(List<Products> products);
	
    Products toProduct(ProductDTO productDTO);

}

