package ru.leonchenko.bankproducts.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.leonchenko.bankproducts.entity.User;
import ru.leonchenko.bankproducts.mapper.ProductMapper;
import ru.leonchenko.bankproducts.mapper.UserMapper;
import ru.leonchenko.bankproducts.repository.UserRepository;
import ru.leonchenko.models.bankproducts.product.get.ProductRsDto;
import ru.leonchenko.models.bankproducts.user.UserRqDto;
import ru.leonchenko.models.bankproducts.user.UserRsDto;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = false)
    public void createUser(UserRqDto request) {

        val username = request.username();

        if (userRepository.existsByUsername(username)) {
            log.info("Пользователь с именем {} уже существует", username);
            return;
        }

        var user = UserMapper.toEntity(request);
        userRepository.save(user);
    }

    public UserRsDto getUserById(Long id) {
        final var user = getUserEntityById(id);
        return UserMapper.toDto(user);
    }

    public List<UserRsDto> getAllUsers() {

        val users = userRepository.findAll();

        return users.stream()
                .map(UserMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = false)
    public void updateUser(Long id, UserRqDto request) {

        final var user = getUserEntityById(id);
        user.setUsername(request.username());
        userRepository.save(user);
    }

    @Transactional(readOnly = false)
    public void deleteUser(Long id) {
        val user = getUserEntityById(id);
        userRepository.delete(user);
    }

    public List<ProductRsDto> getProductsByUserId(Long id) {

        val user = getUserEntityById(id);
        val products = user.getProducts();

        return products.stream()
                .map(ProductMapper::toDto)
                .toList();
    }

    private User getUserEntityById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Пользователь c id " + id + " не найден.")
                );
    }
}
