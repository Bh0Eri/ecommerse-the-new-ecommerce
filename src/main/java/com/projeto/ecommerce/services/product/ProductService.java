package com.projeto.ecommerce.services.product;

import com.projeto.ecommerce.dto.ProductEntityDto;
import com.projeto.ecommerce.entities.ProductEntity;
import com.projeto.ecommerce.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceImp{

    private final ProductRepository productRepository;

    @Override
    public ProductEntityDto create(ProductEntityDto dto) {
        return null;
    }

    @Override
    public Optional<ProductEntityDto> showone(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<ProductEntity> showall() {
        return List.of();
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public ProductEntityDto update(UUID id, ProductEntityDto dto) {
        return null;
    }
}
