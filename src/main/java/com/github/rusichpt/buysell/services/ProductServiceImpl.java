package com.github.rusichpt.buysell.services;

import com.github.rusichpt.buysell.models.Image;
import com.github.rusichpt.buysell.models.Product;
import com.github.rusichpt.buysell.repositories.ProductRepository;
import com.github.rusichpt.buysell.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public void save(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) {
        try {
            if (file1.getSize() != 0) {
                Image image1 = toImageEntity(file1);
                image1.setPreviewImage(true);
                product.addImageToProduct(image1);
            }
            if (file2.getSize() != 0) {
                Image image2 = toImageEntity(file2);
                product.addImageToProduct(image2);
            }
            if (file3.getSize() != 0) {
                Image image3 = toImageEntity(file3);
                product.addImageToProduct(image3);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("Saving new Product: Title {}, Author {}", product.getTitle(), product.getAuthor());
        Product productFromDb = productRepository.save(product);
        if (!productFromDb.getImages().isEmpty()){
            productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        }
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());

        return image;
    }
}
