package ru.leonchenko.users.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) {

        //1. Создаём пользователей
        val userNames = List.of(
                "Ivan Ivanovich",
                "Petr Petrovich",
                "Sergey Sergeevich",
                "Nikolay Nikolaevich");

        userNames.forEach(userService::createUser);

        //2. Получаем всех пользователей
        var users = userService.getAllUsers();
        System.out.println("Все пользователи: " + users);

        //3. Получаем одного пользователя
        val firstUser = users.stream()
                .findFirst()
                .orElseThrow();

        var user = userService.getUserById(firstUser.getId());
        System.out.println("Обновленный пользователь: " + user);

        //4. Обновляем пользователя
        val firstUserId= firstUser.getId();
        userService.updateUser(firstUserId, "Updated " + firstUser.getUsername());
        var updatedUser = userService.getUserById(firstUserId);
        System.out.println("Обновленный пользователь: " + updatedUser);

        //5. Удаляем пользователя
        val secondUser = users
                .stream()
                .skip(1)
                .findFirst()
                .orElseThrow();

        userService.deleteUser(secondUser.getId());
        var usersExist = userService.getAllUsers();
        System.out.println("Все пользователи после удаления: " + usersExist);
    }
}
