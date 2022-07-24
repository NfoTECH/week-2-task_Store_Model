package org.nfotech.model;

public class Product {
    private String category;
    private String name;
    private int quantity;
    private double unitPrice;

    public Product() {

    }


    public Product(String category, String name, int quantity, double unitPrice) {
        this.category = category;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
//
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "PRODUCT -> Category: " + category +
                ", Name: " + name +
                ", Quantity: " + quantity +
                ", Unit Price: " + unitPrice + "\n";
    }
}
