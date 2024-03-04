package com.ecommerce.grocery.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.grocery.dto.AddProduct;
import com.ecommerce.grocery.repository.AddProductRepository;

@Repository
public class ProductDao {
	
	
	@Autowired
	AddProductRepository addProductRepository;

	
	public AddProduct saveProduct(AddProduct addProduct) {
		return addProductRepository.save(addProduct);
	}
	
	
	public AddProduct updateProduct(AddProduct addProduct) {
		Optional< AddProduct> optional= addProductRepository.findById(addProduct.getId());
		if(optional.isPresent()) {
			return addProductRepository.save(addProduct);
		}
		return null;
	}
	
	public AddProduct getProductById(int id) {
		Optional<AddProduct> optional=addProductRepository.findById(id);
		return optional.get();
	}
	
	
	public List< AddProduct> getAllProducts(){
		return addProductRepository.findAll();
	}
	
	
	public List<AddProduct> getByCategory(String category){
		return addProductRepository.getByCategory(category);
	}
	
	
	public List<AddProduct> getByName(String pname){
		return addProductRepository.findByName(pname);
		
	}
	
	
	public long countProduct() {
		return addProductRepository.count();
	}
}
