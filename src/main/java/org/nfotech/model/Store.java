package org.nfotech.model;

import java.util.ArrayList;

public class Store {
    private String storeName;
    private String address;
    private Staff staff;
    private Customer customer;
    private Product product;
    private ArrayList<Product> wareHouse;


    public Store() {
        this.storeName = "NfoTECH Stores";
        this.address = "123 Asajon way, Sangotedo, Lagos";
        this.wareHouse = new ArrayList<>();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ArrayList<Product> getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(ArrayList<Product> wareHouse) {
        this.wareHouse = wareHouse;
    }

    public int productFinder (String productName) {
        for (Product product : this.wareHouse) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return this.wareHouse.indexOf(product);
            }
        }
        return -1;
    }
}
