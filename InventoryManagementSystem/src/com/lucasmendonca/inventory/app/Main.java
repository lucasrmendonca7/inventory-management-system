package com.lucasmendonca.inventory.app;

import java.util.Scanner;
import com.lucasmendonca.inventory.repository.ProductRepository;
import com.lucasmendonca.inventory.service.InventoryService;

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
                    System.out.print("Product name: ");
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    service.addProduct(name, price, quantity);
                    break;

                case 2:
                    service.listAllProducts();
                    break;

                case 3:
                    System.out.print("Product name to update: ");
                    String nameToUpdate = sc.nextLine();

                    System.out.print("New quantity: ");
                    int newQuantity = sc.nextInt();
                    sc.nextLine();

                    service.updateProductQuantity(nameToUpdate, newQuantity);
                    break;

                    
                case 4:
                    System.out.print("Product name to update: ");
                    String nameToUpdateP = sc.nextLine();

                    System.out.print("New price: ");
                    double newPrice = sc.nextInt();
                    sc.nextLine();

                    service.updatePrice(nameToUpdateP, newPrice);
                    break;
                
                case 5:
                    System.out.print("Product name to remove: ");
                    String nameToRemove = sc.nextLine();

                    service.removeProduct(nameToRemove);
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }

        sc.close();
    }
}
