package ru.leonchenko.bankproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.leonchenko.bankproducts.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);
}
