/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.e.commerce.website;

/**
 *
 * @author dhava
 */
// ProductService.java
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public List<Product> getAllProducts() {
        // Replace this with the actual logic to fetch products from the database or any data source
        List<Product> products = new ArrayList<>();
        // Add sample products
        products.add(new Product("1", "Product1", 10.0));
        products.add(new Product("2", "Product2", 15.0));
        return products;
    }

    public Product getProductById(String productId) {
        // Replace this with the actual logic to fetch a product by ID from the database or any data source
        // Return null for now as this is just a placeholder
        return null;
    }
}

