package com.github.rusichpt.buysell.services.interfaces;

import com.github.rusichpt.buysell.models.Product;
import com.github.rusichpt.buysell.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

public interface ProductService {
    List<Product> getAll(String string);

    Product getById(Long id);

    void save(Principal principal, Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3);

    User getUserByPrincipal(Principal principal);

    void delete(Long id);
}
