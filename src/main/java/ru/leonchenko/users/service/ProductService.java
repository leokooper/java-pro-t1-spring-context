package ru.leonchenko.users.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.leonchenko.users.entity.Product;
import ru.leonchenko.users.mapper.ProductMapper;
import ru.leonchenko.users.model.product.ProductRsDto;
import ru.leonchenko.users.repository.ProductRepository;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public ProductRsDto getGetProductById(Long id) {

        final var product = getProductEntityById(id);

        return ProductMapper.toDto(product);
    }

    private Product getProductEntityById(Long id) {
        return productRepository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Продукт c id " + id + " не найден.")
                );
    }
}
