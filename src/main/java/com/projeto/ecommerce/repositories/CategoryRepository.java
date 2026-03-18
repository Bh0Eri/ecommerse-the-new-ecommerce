package com.projeto.ecommerce.repositories;

import com.projeto.ecommerce.dto.CategoryEntityDto;
import com.projeto.ecommerce.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {

    CategoryEntityDto findAllByName(String name);

    Optional<CategoryEntity> findByName(String name);
}
