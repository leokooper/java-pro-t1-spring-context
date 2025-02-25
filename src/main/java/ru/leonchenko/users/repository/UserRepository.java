package ru.leonchenko.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.leonchenko.users.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);
}
