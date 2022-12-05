package com.example.elasticsearch.Product.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Document(indexName = "sample1_dev___products_product_type_1___v1")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@Setting(settingPath = "/elastic/member-setting.json")
@Mapping(mappingPath = "/elastic/member-mapping.json")
public class ProductDocument {

    @Id
    private Long id;

    @Field(value = "reg_date")
    private LocalDateTime regDate;

    @Field(value = "update_date")
    private LocalDateTime updateDate;

    @Field(value = "is_deleted")
    private Boolean isDeleted;

    @Field(value = "delete_date")
    private LocalDateTime deleteDate;

    @Field(value="name" , analyzer = "korean")
    private String name;

    @Field(value = "display_name", analyzer = "korean")
    private String displayName;

    @Field(value="description" , analyzer = "korean")
    private String description;

    private Integer price;

    @Field(value = "sale_price")
    private Integer salePrice;

    @Field(value = "is_hidden")
    private Boolean isHidden;

    @Field(value = "is_sold_out")
    private Boolean isSoldOut;

    @Field(value = "hit_count")
    private Integer hitCount;

    @Field(value = "review_count")
    private Integer reviewCount;

    @Field(value = "review_point")
    private Integer reviewPoint;

    @Field(value = "cate_item_id")
    private Long cateItemId;

    @Field(value = "market_id")
    private Long marketId;


    public static ProductDocument from(Product product) {
        return ProductDocument.builder()
                .id(product.getId())
                .regDate(product.getRegDate())
                .updateDate(product.getUpdateDate())
                .isDeleted(product.getIsDeleted())
                .deleteDate(product.getDeleteDate())
                .name(product.getName())
                .displayName(product.getDisplayName())
                .description(product.getDescription())
                .price(product.getPrice())
                .salePrice(product.getSalePrice())
                .isHidden(product.getIsHidden())
                .isSoldOut(product.getIsSoldOut())
                .hitCount(product.getHitCount())
                .reviewCount(product.getReviewCount())
                .reviewPoint(product.getReviewPoint())
                .cateItemId(product.getCateItemId())
                .marketId(product.getMarketId())
                .build();
    }
}
