package com.projeto.ecommerce.repositories;

import com.projeto.ecommerce.dto.ProductEntityDto;
import com.projeto.ecommerce.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    ProductEntityDto findAllByName(String name);
}
