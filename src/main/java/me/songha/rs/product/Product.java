package me.songha.rs.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import me.songha.rs.purchaseorder.PurchaseOrder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 3839413775522202445L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String manufacturer;
    private int price;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createAt;
    @LastModifiedDate
    private LocalDateTime updateAt;

    @Builder
    public Product(Long id, String productName, String manufacturer, int price, List<PurchaseOrder> purchaseOrders) {
        this.id = id;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.purchaseOrders = purchaseOrders;
    }

    public ProductDto toProductDto() {
        return ProductDto.builder()
                .id(this.id)
                .productName(this.productName)
                .manufacturer(this.manufacturer)
                .price(this.price)
                .createAt(this.createAt)
                .updateAt(this.updateAt).build();
    }
}
