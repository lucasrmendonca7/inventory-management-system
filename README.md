# Inventory Management System

> An inventory management system in Java. *(Currently in development)*

## Overview

This console-based inventory system provides a simple and organized way to manage products.  
It allows users to:

- Add, list, update, and remove products
- Manage product quantities efficiently
- Validate user input to prevent errors
- Maintain a clean and modular code structure

---

## Project Structure

The project is organized into packages for clarity and maintainability:

- `model` → contains the `Product` class (attributes, constructor, getters/setters, `toString`)
- `repository` → contains `ProductRepository` (data storage and CRUD operations)
- `service` → contains `InventoryService` (business logic and input validation)
- `utils` → contains helper classes like `InputUtils` (safe input handling)
- `Main.java` → main class that runs the interactive console menu

---

## Usage

1. Clone the repository:

```bash
git clone <your-repo-url>
