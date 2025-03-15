package ru.leonchenko.bankproducts.mapper;

import ru.leonchenko.bankproducts.entity.User;
import ru.leonchenko.models.bankproducts.user.UserRqDto;
import ru.leonchenko.models.bankproducts.user.UserRsDto;

public class UserMapper {

    public static UserRsDto toDto(User user) {
        return new UserRsDto(
                user.getId(),
                user.getUsername(),
                user.getProducts()
                        .stream()
                        .map(ProductMapper::toDto)
                        .toList()
        );
    }

    public static User toEntity(UserRqDto dto) {
        User user = new User();
        user.setUsername(dto.username());
        return user;
    }
}