package ru.leonchenko.models.bankproducts.user;

import ru.leonchenko.models.bankproducts.product.get.ProductRsDto;

import java.util.List;

public record UserRsDto(Long id, String username, List<ProductRsDto> products) { }
