package org.nfotech;

import org.nfotech.model.*;
import org.nfotech.model.enums.Role;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        Store NfotechStore = new Store();
        StoreContent reStocker = new StoreContent();
        String path = "/Users/decagon/IdeaProjects/week-2-task-NfoTECH/sampledatafoodsales.csv";
        try {
            reStocker.restockWareHouse(path, NfotechStore);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // To check Lists of Products by category
        for (Product products : NfotechStore.getWareHouse()) {
            System.out.println(products);
        }


        Customer Daro = new Customer("Daro", "Decagon Institute", 10000.00);
//        // To check for out of stock
        Daro.buyProduct(Daro, "Carrot", 5, NfotechStore);
        Daro.buyProduct(Daro, "Chocolate Chip", 5, NfotechStore);


//        // A successful Purchase when all conditions are met
        Daro.buyProduct(Daro, "banana", 4, NfotechStore);

//        // Cashier Sell and Print Receipt
        Cashier Ebi = new Cashier("Ebi", 2, Role.CASHIER);
        Ebi.sellProduct(Ebi, Daro);

    }

}
