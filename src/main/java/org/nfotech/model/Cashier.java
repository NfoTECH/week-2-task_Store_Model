package org.nfotech.model;


import org.nfotech.model.enums.Role;

import java.util.List;

public class Cashier extends Staff {
    private int age;
    private StoreContent myStoreContent;

    private Role role;
    public Cashier(String name, int id, Role role) {
        super(name, id);
        this.role = role;
    }
    public Cashier() {

    }

    public int getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double sellProduct(Cashier cashier, Customer customer) {
        if (!cashier.getRole().equals(Role.CASHIER)) {
            System.out.println("Unauthorized access. Please contact the Cashier");
        } else {
            List<Product> customerCart = customer.getCustomerCart();
            double totalAmount = 0;
            for (Product i : customerCart) {
                totalAmount += i.getQuantity() * i.getUnitPrice();
            }
            if (totalAmount <= customer.getWallet()) {
                dispenseReceipt(cashier, customer);
                return totalAmount;
            } else {
                System.out.println("Insufficient Funds");
                return -1;
            }
        }
        return -1;
    }

    public boolean dispenseReceipt(Cashier cashier, Customer customer) {
        if (cashier.getRole().equals(Role.CASHIER)) {
            List<Product> customerCart = customer.getCustomerCart();
            double totalAmount = 0, amount = 0;
            if (!customerCart.isEmpty()){
                System.out.println("****************** YOUR RECEIPT ********************" + "\n" +
                        "P.NAME  | QTY | UNIT PRICE | TOTAL AMOUNT");
                for (Product i : customerCart) {
                    amount = i.getQuantity() * i.getUnitPrice();
                    totalAmount += amount;
                    System.out.println(i.getName() + "    " + i.getQuantity() + "      " + i.getUnitPrice() + "          " + amount);
                }
                System.out.println("Thanks for your patronge" + "\nCustomer name---" + customer.getName() + "\nCustomer address---" + customer.getAddress());
                return true;
            }
            System.out.println("No receipt to dispense");
            return true;
        } else {
            System.out.println("Please contact the cashier");
        }
        return false;
    }
}
