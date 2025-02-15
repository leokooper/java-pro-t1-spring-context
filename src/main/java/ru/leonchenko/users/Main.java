package ru.leonchenko.users;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.leonchenko.users.config.AppConfig;
import ru.leonchenko.users.service.UserService;


public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var userService = context.getBean(UserService.class);

        //1. Создаём пользователей
        userService.createUser("Ivan Ivanovich");
        userService.createUser("Petr Petrovich");
        userService.createUser("Sergey Sergeevich");

        //2. Получаем одного пользователя
        var user = userService.getUserById(1L).orElse(null);
        System.out.println("Обновленный пользователь: " + user);

        //3. Получаем всех пользователей
        var users = userService.getAllUsers();
        System.out.println("Все пользователи: " + users);

        //4. Обновляем пользователя
        userService.updateUser(1L, "Updated Ivan Ivanovich");
        var updatedUser = userService.getUserById(1L).orElse(null);
        System.out.println("Обновленный пользователь: " + updatedUser);

        //5. Удаляем пользователя
        userService.deleteUser(2L);
        var usersExist = userService.getAllUsers();
        System.out.println("Все пользователи после удаления: " + usersExist);

        context.close();
    }
}
