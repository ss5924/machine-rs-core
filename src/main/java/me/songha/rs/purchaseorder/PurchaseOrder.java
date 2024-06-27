package me.songha.rs.purchaseorder;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import me.songha.rs.product.Product;
import me.songha.rs.vendor.Vendor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "purchase_order")
public class PurchaseOrder implements Serializable {
    @Serial
    private static final long serialVersionUID = 6062138816897770863L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String buyer;
    private int quantity;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;

    @Builder
    public PurchaseOrder(Long id, String buyer, int quantity, Product product, Vendor vendor) {
        this.id = id;
        this.buyer = buyer;
        this.quantity = quantity;
        this.product = product;
        this.vendor = vendor;
    }

    public PurchaseOrderDto toPurchaseOrderDto() {
        return PurchaseOrderDto.builder()
                .id(this.id)
                .productDto(this.product.toProductDto())
                .vendorDto(this.vendor.toVendorDto())
                .buyer(this.buyer)
                .quantity(this.quantity)
                .createAt(this.createAt)
                .updateAt(this.updateAt)
                .build();
    }
}
