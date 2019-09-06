package com.product.MapstructUse.pro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor

@RestController
@RequestMapping("/products")
public class ProductAPI {
	@Autowired
	ProductService productService;
	
	@Autowired
	 private  ProductMapperImpl productMapper;
	
	/*
	 * public ProductAPI(ProductService productService, ProductMapper productMapper)
	 * { this.productService = productService; this.productMapper = productMapper; }
	 */
	 
	
	 
	 @GetMapping("/getproduct")
	 public ResponseEntity<List<ProductDTO>> findall()
	 {
		// productMapper.toProductDTOs(productService.getall());
		 System.out.println("inside get");
		 return ResponseEntity.ok(productMapper.toProductDTOs(productService.getall()));
		 
	 }
	 
	    @PostMapping("/postproduct")
	    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
	        productService.save(productMapper.toProduct(productDTO));

	        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
	        Optional<Products> product = productService.findByid(id);

	        return ResponseEntity.ok(productMapper.toProductDTO(product.get()));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
	        Products product = productMapper.toProduct(productDTO);
	      //  product.setId(id);

	        productService.save(product);

	        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	        productService.deleteById(id);

	        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	    }

		public ProductAPI(ProductService productService, ProductMapperImpl productMapper) {
			this.productService = productService;
			this.productMapper = productMapper;
		}


	
	 

}
