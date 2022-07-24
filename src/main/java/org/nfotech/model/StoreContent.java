package org.nfotech.model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class StoreContent {

    public void restockWareHouse (String path, Store store) throws IOException {
        String row;

        BufferedReader reader = new BufferedReader(new FileReader(path));
        while ((row = reader.readLine()) != null) {
            String[] column = row.split(",");

            // Check if product already exists in the store and update with new product
            // If no, create a new product

            if (store.productFinder(column[1]) < 0) {
                Product newProduct = new Product();
                newProduct.setCategory(column[0]);
                newProduct.setName(column[1]);
                newProduct.setQuantity(Integer.parseInt(column[2]));
                newProduct.setUnitPrice(Double.parseDouble(column[3]));

                store.getWareHouse().add(newProduct);
            } else {
                int productIndex = store.productFinder(column[1]);
                Product productInStock = store.getWareHouse().get(productIndex);
                productInStock.setQuantity(productInStock.getQuantity() + Integer.parseInt(column[2]));
            }
        }
    }

}
