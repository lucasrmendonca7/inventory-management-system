package com.lucasmendonca.inventory.service;

import java.util.List;

import com.lucasmendonca.inventory.model.Product;
import com.lucasmendonca.inventory.repository.*;

public class InventoryService {
	private ProductRepository repository;
	
	public InventoryService(ProductRepository repository) {
		this.repository = repository;
	}

	public void addProduct(String name, double price, int quantity) {
		Product existing = repository.findProductByName(name);
	
		if (existing != null) {
			System.out.println("Product already exists!");
			return;
		}
		
		if (name.trim().isEmpty()) {
			System.out.println("Please type something!");
			return;
		}
		
		Product newProduct = new Product(name, price, quantity);
		repository.addProduct(newProduct);
		System.out.println("Product added successfully");
	}

	public void removeProduct(String name) {
		boolean existing = repository.removeProduct(name);
		
		if (!existing) {
			System.out.println("Product not found!");
			return;
		}
		
		System.out.println("Product removed successfully!");
	}
	
	public void updateProductQuantity(String name, int newQuantity) {
		Product product = repository.findProductByName(name);
		
		if (product == null) {
			System.out.println("Product not found!");
			return;
		}
		
		if (newQuantity < 0) {
			System.out.println("Invalid quantity!");
	        return;
		}
		
		repository.updateProductQuantity(name, newQuantity);
		System.out.println("Quantity updated successfully!");
	}

	public void updatePrice(String name, double newPrice) {
		Product product = repository.findProductByName(name);
		
		if (product == null) {
			System.out.println("Product not found!");
			return;
		}
		
		if (newPrice <= 0) {
			System.out.println("Invalid price!");
	        return;
		}
		
		repository.updatePrice(name, newPrice);
		System.out.println("Price updated successfully!");
	}
	public void listAllProducts() {
		List<Product> products = repository.getAllProducts();
		
		if (products.isEmpty()) {
			System.out.println("No products found!");
			return;
		}
		
		for (Product product : products) {
			System.out.println(product);
		}
	}
}
