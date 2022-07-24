package org.nfotech.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    @DisplayName(
            "Should add the product to the customer cart when the product is available in the store")
    void buyProductWhenProductIsAvailableInStoreThenAddToCustomerCart() {
        Store store = new Store();
        Product product = new Product("Bars", "Banana", 79, 2.27);
        store.getWareHouse().add(product);
        Customer customer = new Customer("John", "123 Asajon way, Sangotedo, Lagos", 20000);

        customer.buyProduct(customer, "Banana", 1, store);

        assertEquals(1, customer.getCustomerCart().size());
    }

    @Test
    @DisplayName(
            "Should not add the product to the customer cart when the product is not available in the store")
    void buyProductWhenProductIsNotAvailableInStoreThenNotAddToCustomerCart() {
        Store store = new Store();
        Customer customer = new Customer("John", "123 Asajon way, Sangotedo, Lagos", 10000);
        customer.buyProduct(customer, "Chicken", 1, store);
        assertEquals(0, customer.getCustomerCart().size());
    }
}