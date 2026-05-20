package com.projeto.ecommerce.services.product;

import com.projeto.ecommerce.dto.ProductEntityDto;
import com.projeto.ecommerce.entities.ProductEntity;
import com.projeto.ecommerce.exceptions.ResourceNotFoundException;
import com.projeto.ecommerce.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceImp {

    private final ProductRepository productRepository;

    @Override
    public ProductEntityDto create(ProductEntityDto dto, String imgUrl) {

        ProductEntity product = new ProductEntity();

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImgURL(imgUrl);

        ProductEntity savedProduct = productRepository.save(product);

        return toDto(savedProduct);
    }

    @Override
    public Optional<ProductEntityDto> showone(UUID id) {

        return productRepository.findById(id)
                .map((this::toDto));
    }

    @Override
    public List<ProductEntityDto> showall() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductEntityDto(
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()
                ))
                .toList();
    }

    @Override
    public void delete(UUID id) {

        productRepository.deleteById(id);
    }

    @Override
    public ProductEntityDto update(UUID id, ProductEntityDto dto) {

        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());

        ProductEntity updatedProduct = productRepository.save(product);

        return toDto(updatedProduct);
    }

    private ProductEntityDto toDto(ProductEntity product) {

        return new ProductEntityDto(
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

}