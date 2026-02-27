package com.projeto.ecommerce.services.user;

import com.projeto.ecommerce.dto.UserEntityDto;
import com.projeto.ecommerce.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceImp{
    @Override
    public UserEntityDto create(UserEntityDto dto) {
        return null;
    }

    @Override
    public Optional<UserEntityDto> showone(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<UserEntity> showall() {
        return List.of();
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public UserEntityDto update(UUID id, UserEntityDto dto) {
        return null;
    }
}
