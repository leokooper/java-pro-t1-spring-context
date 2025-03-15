package ru.leonchenko.bankproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.leonchenko.bankproducts.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> { }
