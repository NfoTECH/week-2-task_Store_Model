package org.nfotech.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.nfotech.model.enums.Role;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {

    @Test
    @DisplayName("Should return false when the cashier is not authorized")
    void dispenseReceiptWhenCashierIsNotAuthorizedThenReturnFalse() {
        Cashier cashier = new Cashier("John", 1, Role.MANAGER);
        Customer customer = new Customer("John", "123 Main St", 100);
        assertFalse(cashier.dispenseReceipt(cashier, customer));
    }

    @Test
    @DisplayName("Should return true when the cashier is authorized")
    void dispenseReceiptWhenCashierIsAuthorizedThenReturnTrue() {
        Cashier cashier = new Cashier("John", 1, Role.CASHIER);
        Customer customer = new Customer("John", "123 Main St", 100);
        assertTrue(cashier.dispenseReceipt(cashier, customer));
    }

    @Test
    @DisplayName("Should return total amount when the customer does not have enough money")
    void sellProductWhenCustomerDoesNotHaveEnoughMoneyThenReturnAmount() {
        Cashier cashier = new Cashier("John", 1, Role.CASHIER);
        Customer customer = new Customer("John", "123 Main St", 20);
        Product product = new Product("Bars", "Banana", 5, 2);
        customer.getCustomerCart().add(product);

        double actual = cashier.sellProduct(cashier, customer);

        assertEquals(10, actual);
    }

    @Test
    @DisplayName("Should return -1 when the customer does not have enough money")
    void sellProductWhenCustomerDoesNotHaveEnoughMoneyThenReturnMinusOne() {
        Cashier cashier = new Cashier("John", 1, Role.CASHIER);
        Customer customer = new Customer("John", "123 Main St", 10);
        Product product = new Product("Bars", "Banana", 5, 2.27);
        customer.getCustomerCart().add(product);

        double actual = cashier.sellProduct(cashier, customer);

        assertEquals(-1, actual);
    }

    @Test
    @DisplayName("Should return -1 when the cashier is not a cashier")
    void sellProductWhenCashierIsNotACashierThenReturnMinusOne() {
        Cashier cashier = new Cashier("John", 1, Role.MANAGER);
        Customer customer = new Customer("John", "123 Main St", 100);
        Product product = new Product("Snacks", "Pretzels", 1, 3.15);
        customer.getCustomerCart().add(product);

        double actual = cashier.sellProduct(cashier, customer);

        assertEquals(-1, actual);
    }
}