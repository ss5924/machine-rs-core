package me.songha.rs.product;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ProductDto {
    private Long id;
    private String productName;
    private String manufacturer;
    private int price;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Product toEntity() {
        return Product.builder()
                .id(this.id)
                .productName(this.productName)
                .manufacturer(this.manufacturer)
                .price(this.price)
                .build();
    }
}
