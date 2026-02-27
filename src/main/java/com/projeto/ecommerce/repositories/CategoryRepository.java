package com.projeto.ecommerce.repositories;

import com.projeto.ecommerce.dto.CategoryEntityDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryEntityDto, UUID> {

    CategoryEntityDto findAllByName(String name);
}
