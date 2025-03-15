package ru.leonchenko.bankproducts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.leonchenko.models.bankproducts.enums.ProductType;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "product_type")
    @Enumerated(STRING)
    private ProductType productType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}