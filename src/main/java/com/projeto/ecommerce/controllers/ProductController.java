package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.dto.ProductEntityDto;
import com.projeto.ecommerce.entities.ProductEntity;
import com.projeto.ecommerce.exceptions.ResourceNotFoundException;
import com.projeto.ecommerce.services.product.PhotoService;
import com.projeto.ecommerce.services.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final PhotoService photoService;

    @PostMapping
    public ResponseEntity<ProductEntityDto> create(@RequestBody @Valid ProductEntityDto dto,
                                                   @RequestParam MultipartFile imgUrl) throws IOException {

        String pathPhoto =photoService.saveP(imgUrl);

        return ResponseEntity.ok(productService.create(dto.getName(), dto.getDescription(), dto.getPrice()));
    }

    @GetMapping
    public ResponseEntity<List<ProductEntityDto>> showAll(){

        List<ProductEntityDto> products = productService.showall();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntityDto> showOne(@PathVariable UUID id){

        ProductEntityDto product = productService.showone(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntityDto> update(
            @PathVariable UUID id,
            @Valid @RequestBody ProductEntityDto dto){

        ProductEntityDto updated = productService.update(id, dto);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){

        productService.delete(id);

        return ResponseEntity.noContent().build();
    }

}