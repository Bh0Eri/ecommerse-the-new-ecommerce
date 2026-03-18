package com.projeto.ecommerce.services.user;

import com.projeto.ecommerce.dto.UserEntityDto;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.exceptions.ResourceNotFoundException;
import com.projeto.ecommerce.repositories.UserRepository;
import com.projeto.ecommerce.services.user.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceImp {

    private final UserRepository userRepository;

    @Override
    public UserEntityDto create(UserEntityDto dto) {

        UserEntity user = new UserEntity();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        UserEntity savedUser = userRepository.save(user);

        return toDto(savedUser);
    }

    @Override
    public Optional<UserEntityDto> showone(UUID id) {

        return userRepository.findById(id)
                .map(this::toDto);
    }

    @Override
    public List<UserEntity> showall() {

        return userRepository.findAll();
    }

    @Override
    public void delete(UUID id) {

        userRepository.deleteById(id);
    }

    @Override
    public UserEntityDto update(UUID id, UserEntityDto dto) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        UserEntity updatedUser = userRepository.save(user);

        return toDto(updatedUser);
    }

    private UserEntityDto toDto(UserEntity user){

        UserEntityDto dto = new UserEntityDto();

        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());

        return dto;
    }
}