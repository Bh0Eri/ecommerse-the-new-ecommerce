package com.projeto.ecommerce.services.category;

import com.projeto.ecommerce.dto.CategoryEntityDto;
import com.projeto.ecommerce.entities.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryServiceImp{
    @Override
    public CategoryEntityDto create(CategoryEntityDto dto) {

        return null;
    }

    @Override
    public CategoryEntityDto update(UUID id, CategoryEntityDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<CategoryEntityDto> showall() {
        return List.of();
    }

    @Override
    public Optional<CategoryEntity> showone(String name) {
        return Optional.empty();
    }
}
