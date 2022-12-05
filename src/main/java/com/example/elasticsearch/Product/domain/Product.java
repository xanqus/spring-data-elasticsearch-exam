package com.example.elasticsearch.Product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Document(indexName = "sample1_dev___products_product_type_1___v1")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime regDate;

    private LocalDateTime updateDate;

    private Boolean isDeleted;

    private LocalDateTime deleteDate;

    private String name;

    private String displayName;

    private String description;

    private Integer price;

    private Integer salePrice;

    private Boolean isHidden;

    private Boolean isSoldOut;

    private Integer hitCount;

    private Integer reviewCount;

    private Integer reviewPoint;

    private Long cateItemId;

    private Long marketId;


}


