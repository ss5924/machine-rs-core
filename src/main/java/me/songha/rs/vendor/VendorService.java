package me.songha.rs.vendor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorDto getVendor(Long id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"))
                .toVendorDto();
    }

    public VendorDto save(VendorDto vendorDto) {
        return vendorRepository.save(vendorDto.toEntity()).toVendorDto();
    }
}
