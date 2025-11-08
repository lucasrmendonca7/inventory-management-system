package com.lucasmendonca.inventory.repository;

import com.lucasmendonca.inventory.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
	private List<Product> products;
	
	public ProductRepository() {
		this.products = new ArrayList<>();
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public boolean removeProduct(String name) {
		Product found = findProductByName(name);
		
		if (found != null) {
			this.products.remove(found);
			return true;
		}
		return false;
	}
	
	public Product findProductByName(String name) {
		for (Product product : products) {
			if (product.getName().equalsIgnoreCase(name)) {
				return product;
			}
		}
		return null;
	}
	
	public void updateProductQuantity(String name, int  newQuantity) {
		Product product = findProductByName(name);
		if (product != null) {
			product.setQuantity(newQuantity);
		}
	}
	
	public void updatePrice(String name, double newPrice) {
		Product product = findProductByName(name);
		if (product != null) {
			product.setPrice(newPrice);
		}
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
