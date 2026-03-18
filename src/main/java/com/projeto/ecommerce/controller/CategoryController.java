package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.dto.CategoryEntityDto;
import com.projeto.ecommerce.entities.CategoryEntity;
import com.projeto.ecommerce.exceptions.ResourceNotFoundException;
import com.projeto.ecommerce.services.category.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryEntityDto> create(@Valid @RequestBody CategoryEntityDto dto){

        CategoryEntityDto created = categoryService.create(dto);

        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<CategoryEntityDto>> showAll(){

        List<CategoryEntityDto> categories = categoryService.showall();

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategoryEntity> showOne(@PathVariable String name){

        CategoryEntity category = categoryService.showone(name)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryEntityDto> update(
            @PathVariable UUID id,
            @Valid @RequestBody CategoryEntityDto dto){

        CategoryEntityDto updated = categoryService.update(id, dto);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){

        categoryService.delete(id);

        return ResponseEntity.noContent().build();
    }

}