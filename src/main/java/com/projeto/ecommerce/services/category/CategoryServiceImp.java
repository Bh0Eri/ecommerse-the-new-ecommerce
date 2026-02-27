package com.projeto.ecommerce.services.category;

import com.projeto.ecommerce.dto.CategoryEntityDto;
import com.projeto.ecommerce.entities.CategoryEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryServiceImp {


    CategoryEntityDto create(CategoryEntityDto dto);

    CategoryEntityDto update(UUID id, CategoryEntityDto dto);

    void delete(UUID id);

    List<CategoryEntityDto> showall();

    Optional<CategoryEntity> showone(String name);



}
