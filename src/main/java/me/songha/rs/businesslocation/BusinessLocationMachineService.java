package me.songha.rs.businesslocation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BusinessLocationMachineService {
    private final BusinessLocationRepository businessLocationRepository;

    public BusinessLocationDto getBusinessLocationDto(Long id) {
        return businessLocationRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"))
                .toBusinessLocationDto();
    }

}
