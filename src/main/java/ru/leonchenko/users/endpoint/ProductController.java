package ru.leonchenko.users.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.leonchenko.users.model.product.ProductRsDto;
import ru.leonchenko.users.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductRsDto getGetProductById(@PathVariable Long id) {
        return productService.getGetProductById(id);
    }
}
