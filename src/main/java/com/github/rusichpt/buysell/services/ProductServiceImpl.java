package com.github.rusichpt.buysell.services;

import com.github.rusichpt.buysell.models.Product;
import com.github.rusichpt.buysell.services.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private static long ID = 0;
    List<Product> products = new ArrayList<>();

    {
        products.add(new Product(++ID, "PlayStation 5", "Очень хорошая", 60000, "Воронеж", "Андрей"));
        products.add(new Product(++ID, "iPhone 6", "Стабильный", 11000, "Краснодар", "Валера"));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(long id) {
        for (Product p:products) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    @Override
    public void save(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    @Override
    public void delete(long id) {
        products.removeIf((product) -> product.getId() == id);
    }
}
