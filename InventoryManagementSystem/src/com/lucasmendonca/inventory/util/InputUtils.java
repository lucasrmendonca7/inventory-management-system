package com.lucasmendonca.inventory.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

    public static int readInt(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("❌ Please enter a valid number!");
                sc.nextLine(); 
            }
        }
    }

    public static double readDouble(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("❌ Please enter a valid number!");
                sc.nextLine();
            }
        }
    }

    public static String readString(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
            if (!input.isBlank()) {
                return input;
            }
            System.out.println("⚠️ Please type something!");
        }
    }
}
