package com.projeto.ecommerce.services.product;

import com.projeto.ecommerce.dto.ProductEntityDto;
import com.projeto.ecommerce.entities.ProductEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductServiceImp {

    ProductEntityDto create(ProductEntityDto dto);

    Optional<ProductEntityDto> showone(UUID id);

    List<ProductEntity> showall();

    void delete(UUID id);

    ProductEntityDto update(UUID id, ProductEntityDto dto);

}
