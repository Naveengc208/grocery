package com.ecommerce.grocery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.grocery.dto.AddProduct;

public interface AddProductRepository extends JpaRepository<AddProduct, Integer> {

	
	@Query("select a from AddProduct a where a.category=:category")
	List<AddProduct> getByCategory(@RequestParam("category") String category);
	
	@Query("select a from AddProduct a where a.pname LIKE %:pname%")
	public abstract List<AddProduct> findByName(@RequestParam("pname") String pname);
}
