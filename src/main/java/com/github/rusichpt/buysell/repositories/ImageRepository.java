package com.github.rusichpt.buysell.repositories;

import com.github.rusichpt.buysell.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
