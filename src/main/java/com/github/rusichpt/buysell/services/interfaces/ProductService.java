package com.github.rusichpt.buysell.services.interfaces;

import com.github.rusichpt.buysell.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(Long id);
    void save(Product product);
    void delete(Long id);
}
