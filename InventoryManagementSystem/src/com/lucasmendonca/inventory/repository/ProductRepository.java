package com.lucasmendonca.inventory.repository;

import com.lucasmendonca.inventory.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
	private List<Product> products = new ArrayList<>();
			
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public boolean removeProduct(String name) {
		Product found = findProductByName(name);
		
		if (found != null) {
			products.remove(found);
			return true;
		}
		return false;
	}
	
	public Product findProductByName(String name) {
		for (Product p : products) {
			if (p.getName().equalsIgnoreCase(name)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean updateProductQuantity(String name, int  newQuantity) {
		Product p = findProductByName(name);
		if (p != null) {
			p.setQuantity(newQuantity);
			return true;
		}
		return false;
		
	}
	
	public void showProducts() {
		for (Product product : products) {
			System.out.println(product);
		}
	}	
	public List<Product> getAllProducts() {
		return products;
	}
}
