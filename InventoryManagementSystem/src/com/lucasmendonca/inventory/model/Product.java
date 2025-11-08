package com.lucasmendonca.inventory.model;

public class Product {
	private String name;
	private double price;
	private int quantity;
	
	public Product(String name, double price, int quantity) {
		this.name = name.toUpperCase();
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	} 
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return String.format("Name: %s | Price: $%.2f | Quantity: %d", name, price, quantity);
	}
}

