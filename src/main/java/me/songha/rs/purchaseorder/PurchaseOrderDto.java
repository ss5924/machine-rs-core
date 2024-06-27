package me.songha.rs.purchaseorder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Builder;
import lombok.Data;
import me.songha.rs.product.ProductDto;
import me.songha.rs.vendor.VendorDto;

import java.time.LocalDateTime;

@Builder
@Data
public class PurchaseOrderDto {
    private Long id;
    private String buyer;
    private int quantity;
    private ProductDto productDto;
    private VendorDto vendorDto;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createAt;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateAt;

    @JsonCreator
    public PurchaseOrderDto(
            @JsonProperty("id") Long id,
            @JsonProperty("buyer") String buyer,
            @JsonProperty("quantity") int quantity,
            @JsonProperty("productDto") ProductDto productDto,
            @JsonProperty("vendorDto") VendorDto vendorDto,
            @JsonProperty("createAt") LocalDateTime createAt,
            @JsonProperty("updateAt") LocalDateTime updateAt) {
        this.id = id;
        this.buyer = buyer;
        this.quantity = quantity;
        this.productDto = productDto;
        this.vendorDto = vendorDto;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public PurchaseOrder toEntity() {
        return PurchaseOrder.builder()
                .id(this.id)
                .buyer(this.buyer)
                .quantity(this.quantity)
                .product(this.productDto.toEntity())
                .vendor(this.vendorDto.toEntity())
                .build();
    }

}
