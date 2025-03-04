package ru.leonchenko.users.mapper;

import ru.leonchenko.users.entity.User;
import ru.leonchenko.users.model.user.UserRqDto;
import ru.leonchenko.users.model.user.UserRsDto;

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