/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.e.commerce.website;

/**
 *
 * @author dhava
 */
import java.util.List;

public class ECommerceWebSite {

    private static ProductService productService = new ProductService();

    public static void main(String[] args) {
        // Instantiate services and perform necessary operations
        ProductService productService = new ProductService();
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();
        UserService userService = new UserService();

        // Example operations
        // Fetch all products
        List<Product> products = productService.getAllProducts();
        System.out.println("All Products:");
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId() + ", Product Name: " + product.getName());
        }

        // Add an item to the cart
        String userId = "user123";
        String productId = "1";
        int quantity = 2;
        cartService.addToCart(userId, productId, quantity);

        // Place an order
        Order order = new Order("1234", userId, cartService.getCartItems(userId), 100.0);
        order.setUserId(userId);
        List<CartItem> cartItems = cartService.getCartItems(userId);
        order.setItems(cartItems);
        double totalAmount = calculateTotalAmount(cartItems);
        order.setTotalAmount(totalAmount);
        orderService.placeOrder(order);

        // Fetch user details
        String fetchedUserId = "user456";
        User user = userService.getUserById(fetchedUserId);
        if (user != null) {
            System.out.println("Fetched User: " + user.getUsername());
        }
    }

    private static double calculateTotalAmount(List<CartItem> cartItems) {
        double total = 0;
        for (CartItem cartItem : cartItems) {
            Product product = productService.getProductById(cartItem.getProductId());
            total += product != null ? product.getPrice() * cartItem.getQuantity() : 0;
        }
        return total;
    }
}
