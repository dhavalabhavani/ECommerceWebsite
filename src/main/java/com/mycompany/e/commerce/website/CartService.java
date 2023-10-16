/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.e.commerce.website;

/**
 *
 * @author dhava
 */
// CartService.java
import java.util.List;
import java.util.ArrayList;

public class CartService {
    private List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getCartItems(String userId) {
        List<CartItem> userCartItems = new ArrayList<>();
        for (CartItem item : cartItems) {
            if (item.getUserId().equals(userId)) {
                userCartItems.add(item);
            }
        }
        return userCartItems;
    }

    public void addToCart(String userId, String productId, int quantity) {
        // Check if the product already exists in the user's cart
        for (CartItem item : cartItems) {
            if (item.getUserId().equals(userId) && item.getProductId().equals(productId)) {
                // If it does, update the quantity
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        // If the product doesn't exist, add it to the cart
        cartItems.add(new CartItem(userId, productId, quantity));
    }

    public void removeFromCart(String userId, String productId) {
        for (CartItem item : cartItems) {
            if (item.getUserId().equals(userId) && item.getProductId().equals(productId)) {
                cartItems.remove(item);
                return;
            }
        }
    }
}

