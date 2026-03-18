package com.projeto.ecommerce.services.category;

import com.projeto.ecommerce.dto.CategoryEntityDto;
import com.projeto.ecommerce.entities.CategoryEntity;
import com.projeto.ecommerce.exceptions.ResourceNotFoundException;
import com.projeto.ecommerce.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryServiceImp {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryEntityDto create(CategoryEntityDto dto) {

        CategoryEntity category = new CategoryEntity();
        category.setName(dto.getName());

        CategoryEntity savedCategory = categoryRepository.save(category);

        return new CategoryEntityDto(savedCategory.getName());
    }

    @Override
    public CategoryEntityDto update(UUID id, CategoryEntityDto dto) {

        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        category.setName(dto.getName());

        CategoryEntity updated = categoryRepository.save(category);

        return new CategoryEntityDto(updated.getName());
    }

    @Override
    public void delete(UUID id) {

        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryEntityDto> showall() {

        return categoryRepository.findAll()
                .stream()
                .map(category -> new CategoryEntityDto(
                        category.getName()
                ))
                .toList();
    }

    @Override
    public Optional<CategoryEntity> showone(String name) {

        return categoryRepository.findByName(name);
    }
}