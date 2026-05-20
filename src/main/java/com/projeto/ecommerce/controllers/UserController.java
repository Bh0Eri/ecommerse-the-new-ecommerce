package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.dto.UserEntityDto;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.services.PhotoService;
import com.projeto.ecommerce.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PhotoService photoService;

    // Público - cadastro
    @PostMapping("/register")
    public ResponseEntity<UserEntityDto> create(@RequestBody UserEntityDto dto,
                                                @RequestParam MultipartFile file) throws IOException {

        String pathUrl =photoService.saveP(file);
        return ResponseEntity.ok(userService.create(dto, pathUrl));
    }

    // ADMIN - listar todos
    @GetMapping
    public ResponseEntity<List<UserEntity>> showAll() {
        return ResponseEntity.ok(userService.showall());
    }

    // USER - buscar um
    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserEntityDto>> showOne(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.showone(id));
    }

    // USER - atualizar
    @PutMapping("/{id}")
    public ResponseEntity<UserEntityDto> update(
            @PathVariable UUID id,
            @RequestBody UserEntityDto dto) {
        return ResponseEntity.ok(userService.update(id, dto));
    }

    // ADMIN - deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}