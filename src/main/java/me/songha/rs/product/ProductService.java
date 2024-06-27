package me.songha.rs.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductDto getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"))
                .toProductDto();
    }

}
