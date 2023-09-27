package com.github.rusichpt.buysell.services;

import com.github.rusichpt.buysell.models.Product;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceImplTest {

    private final ProductServiceImpl service;

    @Autowired
    ProductServiceImplTest(ProductServiceImpl service) {
        this.service = service;
    }

    @Test
    void getById() {
        Assertions.assertThrows(LazyInitializationException.class, () -> {
            Product product = service.getById(1L);
            System.out.println(product);
        });
    }
}