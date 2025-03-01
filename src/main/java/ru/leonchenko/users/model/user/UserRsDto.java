package ru.leonchenko.users.model.user;

import ru.leonchenko.users.model.product.ProductRsDto;

import java.util.List;

public record UserRsDto(Long id, String username, List<ProductRsDto> products) { }
