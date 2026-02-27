package com.projeto.ecommerce.dto;

import com.projeto.ecommerce.enums.RoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.projeto.ecommerce.entities.UserEntity}
 */
/**
 * DTO for {@link com.projeto.ecommerce.repositories.UserEntity}
 */
@Value
public class UserEntityDto implements Serializable {
    @NotNull
    @Size(min = 4, max = 20)
    String name;
    @Email
    String email;
    @NotNull
    String phone;
    @NotNull
    @Size(message = "more than 6 digits", min = 6, max = 30)
    String password;
    RoleEnum roles;
    @NotNull
    List<OrderEntityDto> orders;
}