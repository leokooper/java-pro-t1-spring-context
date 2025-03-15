package ru.leonchenko.bankproducts.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.leonchenko.bankproducts.entity.Product;
import ru.leonchenko.bankproducts.mapper.ProductMapper;
import ru.leonchenko.bankproducts.repository.ProductRepository;
import ru.leonchenko.models.bankproducts.product.get.ProductRsDto;
import ru.leonchenko.models.bankproducts.product.updatebalance.UpdateBalanceRqDto;
import ru.leonchenko.models.bankproducts.product.updatebalance.UpdateBalanceRsDto;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public ProductRsDto getGetProductById(Long id) {

        val product = getProductEntityById(id);

        return ProductMapper.toDto(product);
    }

    @Transactional(readOnly = false)
    public UpdateBalanceRsDto updateProduct(Long id, UpdateBalanceRqDto rq) {

        val product = getProductEntityById(id);
        val newBalance = product.getBalance().subtract(rq.paymentAmount());
        product.setBalance(newBalance);
        return ProductMapper.toUpdateBalanceRsDto(product);
    }

    private Product getProductEntityById(Long id) {
        return productRepository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Продукт c id " + id + " не найден.")
                );
    }
}
