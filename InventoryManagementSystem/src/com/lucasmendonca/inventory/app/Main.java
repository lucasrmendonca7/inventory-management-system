package com.lucasmendonca.inventory.app;

import java.util.Scanner;
import com.lucasmendonca.inventory.repository.ProductRepository;
import com.lucasmendonca.inventory.service.InventoryService;
import com.lucasmendonca.inventory.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductRepository repo = new ProductRepository();
		InventoryService  service = new InventoryService(repo);
		int option = -1;

        while (option != 0) {
            System.out.println("\n=== INVENTORY SYSTEM ===");
            System.out.println("1. Add product");
            System.out.println("2. List all products");
            System.out.println("3. Update product quantity");
            System.out.println("4. Update price");
            System.out.println("5. Remove product");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    String name1 = InputUtils.readString(sc, "Product name: ");
                    double price = InputUtils.readDouble(sc, "Price: ");
                    int quantity = InputUtils.readInt(sc, "Quantity: ");

                    service.addProduct(name1, price, quantity);
                    break;

                case 2:
                    service.listAllProducts();
                    break;

                case 3:
                	String name2 = InputUtils.readString(sc, "Product name to update: ");
                	int newQuantity = InputUtils.readInt(sc, "New quantity: ");
                    service.updateProductQuantity(name2, newQuantity);
                    break;

                case 4:
                	String name3 = InputUtils.readString(sc, "Product name to update: ");
                	double newPrice = InputUtils.readDouble(sc, "New price: ");

                    service.updatePrice(name3, newPrice);
                    break;
                
                case 5:
                	String nameToRemove = InputUtils.readString(sc, "Product name to remove: ");

                    service.removeProduct(nameToRemove);
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option! ");
                    break;
            }
        }

        sc.close();
    }
}
