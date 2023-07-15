package com.github.rusichpt.buysell.services;

import com.github.rusichpt.buysell.models.Image;
import com.github.rusichpt.buysell.repositories.ImageRepository;
import com.github.rusichpt.buysell.services.interfaces.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;

    @Override
    public Image getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
