package com.projeto.ecommerce.services.user;

import com.projeto.ecommerce.dto.UserEntityDto;
import com.projeto.ecommerce.entities.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserServiceImp {

    UserEntityDto create(UserEntityDto dto);

    Optional<UserEntityDto> showone(UUID id);

    List<UserEntity> showall();

    void delete(UUID id);

    UserEntityDto update(UUID id, UserEntityDto dto);




}
