package ru.leonchenko.paymentcore.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.leonchenko.models.bankproducts.product.get.ProductRsDto;
import ru.leonchenko.paymentcore.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productsService;

    @GetMapping("/clients/{id}")
    public List<ProductRsDto> getProductsByClient(@PathVariable Long id) {
        return productsService.getProductsByClient(id);
    }
}
