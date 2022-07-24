package org.nfotech.model;

import org.nfotech.model.enums.Role;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String address;
    private Role role;
    private double wallet;
    private ArrayList<Product> customerCart = new ArrayList<>();

    public Customer(String name, String address, double wallet ) {
        this.name = name;
        this.address = address;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Customer(Role role) {
        this.role = role;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Product> getCustomerCart() {
        return customerCart;
    }

    public void setCustomerCart(ArrayList<Product> customerCart) {
        this.customerCart = customerCart;
    }

    // Customer buys a product
    public void buyProduct (Customer customer, String productName, int quantity, Store store) {
        int productInStoreIndex = store.productFinder((productName));
        if (productInStoreIndex >= 0) {
            Product productInStore = store.getWareHouse().get(productInStoreIndex);
            if (productInStore.getQuantity() < quantity) {
                System.out.println("Product Out of Stock");
            } else {
                // Create new Product with the following quantites
                Product purchasedProduct = new Product();
                purchasedProduct.setCategory(productInStore.getName());
                purchasedProduct.setName(productInStore.getName());
                purchasedProduct.setQuantity(quantity);
                purchasedProduct.setUnitPrice(productInStore.getUnitPrice());
                customer.getCustomerCart().add(purchasedProduct);
                productInStore.setQuantity((productInStore.getQuantity() - quantity));
                System.out.println(productInStore.getName() + " added to the cart");
            }
        } else {
            System.out.println("Product not available");
        }
    }

}
