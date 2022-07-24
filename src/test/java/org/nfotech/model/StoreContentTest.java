package org.nfotech.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StoreContentTest {
    private static Store store;
    private static String path = "/Users/decagon/Desktop/week-2-task-NfoTECH-Copy/src/test/resources/sampledatafoodsales.csv";

    static Store init() throws IOException {
        Store newStore = new Store();
        newStore.setAddress("test address");
        newStore.setStoreName("test name");
        store = newStore;
        StoreContent storeContent = new StoreContent();
        storeContent.restockWareHouse(path, store);
        return store;
    }

    @Test
    @DisplayName("test to restock warehouse")
    void testToReStockWareHouse() throws IOException {
        store = init();
        assertEquals(4, store.getWareHouse().size());
    }

}
