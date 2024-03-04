package com.ecommerce.grocery.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.grocery.dao.ProductDao;
import com.ecommerce.grocery.dto.AddProduct;
import com.ecommerce.grocery.repository.AddProductRepository;

@Service
public class ProductService {

	
	static int id=0;
	@Autowired
	ProductDao dao;
	@Autowired
	AddProductRepository addProductRepository;
	
	public AddProduct uploadImage(MultipartFile file) throws IOException{
		AddProduct addProduct= new AddProduct();
		addProduct.setImage(file.getBytes());
		
		
		AddProduct addProduct2= dao.saveProduct(addProduct);
		if(addProduct2!=null) {
			id=addProduct2.getId();
		}
		return addProduct2;
	}
	
	
	public AddProduct saveAddProduct(AddProduct addProduct) {
		AddProduct addProduct2=dao.getProductById(id);
		if(addProduct2!=null) {
			addProduct2.setPname(addProduct.getPname());
			addProduct2.setpPrice(addProduct.getpPrice());
			addProduct2.setOfferPrice(addProduct.getOfferPrice());
			addProduct2.setQuantity(addProduct.getQuantity());
			addProduct2.setCategory(addProduct.getCategory());
			return dao.updateProduct(addProduct2);
		}
		return null;
	}
	
	
	public AddProduct getProductById(int id) {
		AddProduct addProduct= dao.getProductById(id);
		if(addProduct.getImage()!=null) {
			try {
				byte[] pic = addProduct.getImage();
				FileOutputStream fileOutputStream=new FileOutputStream("d:/pic.jpeg");
				fileOutputStream.write(pic);
			}catch (IOException e) {
				return null;
			}
		}
		return addProduct;
	}
	
	
	public AddProduct updateProduct(AddProduct addProduct) {
		if(addProduct!=null) {
			addProduct.setDate(LocalDateTime.now());
			try {
				FileInputStream fileInputStream= new FileInputStream("d:/pic.jpeg");
				byte[] img=fileInputStream.readAllBytes();
				addProduct.setImage(img);
			}catch (IOException e) {
				return null;
			}
		}
		
		return dao.updateProduct(addProduct);
	}
	
	
	public List<AddProduct> getAllProducts(){
		return dao.getAllProducts();
	}
	
	
	public AddProduct getImageById(int id) {
		return addProductRepository.findById(id).orElse(null);
	}
	
	public List<AddProduct> getByCategory(String category){
		return addProductRepository.getByCategory(category);
	}
	
	
	public List<AddProduct> getByName(String pname){
		return addProductRepository.findByName(pname);
	}
	
	public long countProduct() {
		return dao.countProduct();
	}
}
