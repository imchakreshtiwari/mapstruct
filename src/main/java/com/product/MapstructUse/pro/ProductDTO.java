package com.product.MapstructUse.pro;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class ProductDTO {
	
	private String name;
    private String description;
    private BigDecimal price;
    
    
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
