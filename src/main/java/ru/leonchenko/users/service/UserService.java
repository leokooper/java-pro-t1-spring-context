package ru.leonchenko.users.service;

import org.springframework.stereotype.Service;
import ru.leonchenko.users.entity.User;
import ru.leonchenko.users.repository.UserDao;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUser(String username) {
        userDao.createUser(username);
    }

    public Optional<User> getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void updateUser(Long id, String newUsername) {
        userDao.updateUser(id, newUsername);
    }

    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
