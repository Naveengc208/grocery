package com.ecommerce.grocery.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.grocery.dto.AddProduct;
import com.ecommerce.grocery.service.ProductService;

@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	@PostMapping("/addproduct/image")
	public AddProduct uploadImage(@RequestParam("image") MultipartFile file)  throws IOException{
		return productService.uploadImage(file);
		
	}
	
	@PostMapping("/addproduct")
	public AddProduct saveProduct(@RequestBody AddProduct addProduct) {
		return productService.saveAddProduct(addProduct);
	}
	
	
@GetMapping("/products/{id}")
	public AddProduct getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	
	@PutMapping("/addproduct")
	public  AddProduct updateProduct(@RequestBody AddProduct addProduct) {
		return productService.updateProduct(addProduct);
	}
	
	
	@GetMapping("/addproduct")
	public List<AddProduct> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AddProduct> getImageById(@PathVariable int id){
		AddProduct addProduct= productService.getImageById(id);
		return ResponseEntity.ok(addProduct);
	}
	
	
	@GetMapping("/addproduct/{category}")
	public List<AddProduct> getByCategory(@PathVariable String category){
		return productService.getByCategory(category);
	}
	
	
	@GetMapping("/addproducts/{pname}")
	public List<AddProduct> getByName(@PathVariable String pname){
		return productService.getByName(pname);
	}
	
//	 @GetMapping("/product/count")
//	    public ResponseEntity<Long> getProductCount() {
//	        long count = productService.countProduct();
//	        return new ResponseEntity<>(count, HttpStatus.OK);
//	    }
}
