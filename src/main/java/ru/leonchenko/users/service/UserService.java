package ru.leonchenko.users.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.leonchenko.users.entity.User;
import ru.leonchenko.users.repository.UserRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = false)
    public void createUser(String username) {
        if (userRepository.existsByUsername(username)) {
            log.info("Пользователь с именем {} уже существует", username);
            return;
        }

        var user = new User();
        user.setUsername(username);
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Пользователь c id " + id + " не найден.")
        );
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void updateUser(Long id, String newUsername) {
        var user = getUserById(id);
        user.setUsername(newUsername);
        userRepository.save(user);
    }

    @Transactional(readOnly = false)
    public void deleteUser(Long id) {
        val user = getUserById(id);
        userRepository.delete(user);
    }
}
