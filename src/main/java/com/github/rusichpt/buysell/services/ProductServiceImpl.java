package com.github.rusichpt.buysell.services;

import com.github.rusichpt.buysell.models.Product;
import com.github.rusichpt.buysell.repositories.ProductRepository;
import com.github.rusichpt.buysell.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll(String title) {
        if (title != null)
            return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        log.info("Saving new {}", product);
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
