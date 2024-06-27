package me.songha.rs.purchaseorder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PurchaseOrderService {
    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderDto getPurchaseOrder(Long id) {
        return purchaseOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"))
                .toPurchaseOrderDto();
    }

}
