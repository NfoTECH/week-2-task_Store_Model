package org.nfotech.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    @Test
    @DisplayName("test return index of product to find")
    void testReturnIndexToFind() throws IOException {
        Store store = StoreContentTest.init();
        int index = store.productFinder("Carrot");
        assertEquals(0, index);
    }

    @Test
    @DisplayName("test return -1 of product to find")
    void testReturnIndexNotFound() throws IOException {
        Store store = StoreContentTest.init();
        int index = store.productFinder("Nothing");
        assertEquals(-1, index);
    }
}
