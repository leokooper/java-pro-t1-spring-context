package ru.leonchenko.bankproducts.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.leonchenko.bankproducts.service.ProductService;
import ru.leonchenko.models.bankproducts.product.get.ProductRsDto;
import ru.leonchenko.models.bankproducts.product.updatebalance.UpdateBalanceRqDto;
import ru.leonchenko.models.bankproducts.product.updatebalance.UpdateBalanceRsDto;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductRsDto getGetProductById(@PathVariable Long id) {
        return productService.getGetProductById(id);
    }

    @PutMapping("/{id}")
    public UpdateBalanceRsDto updateBalance(
            @PathVariable Long id,
            @RequestBody UpdateBalanceRqDto rq) {
        return productService.updateProduct(id, rq);
    }
}
