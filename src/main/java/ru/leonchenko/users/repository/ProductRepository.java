package ru.leonchenko.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.leonchenko.users.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> { }
