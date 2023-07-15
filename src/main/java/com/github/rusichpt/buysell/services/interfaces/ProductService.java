package com.github.rusichpt.buysell.services.interfaces;

import com.github.rusichpt.buysell.models.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> getAll(String string);

    Product getById(Long id);
    void save(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3);
    void delete(Long id);
}
