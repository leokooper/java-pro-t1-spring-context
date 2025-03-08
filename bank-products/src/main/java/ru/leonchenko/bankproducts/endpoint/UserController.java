package ru.leonchenko.bankproducts.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.leonchenko.bankproducts.service.UserService;
import ru.leonchenko.models.bankproducts.product.get.ProductRsDto;
import ru.leonchenko.models.bankproducts.user.UserRqDto;
import ru.leonchenko.models.bankproducts.user.UserRsDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody UserRqDto request) {
        userService.createUser(request);
    }

    @GetMapping("/{id}")
    public UserRsDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserRsDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public void updateUser(
            @PathVariable Long id,
            @RequestBody UserRqDto request
    ) {
        userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/products")
    public List<ProductRsDto> getProductsByUserId(@PathVariable Long id) {
        return userService.getProductsByUserId(id);
    }
}
