package me.songha.rs.machine;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MachineService {
    private final MachineRepository machineRepository;

    public MachineDto getMachineDto(Long id) {
        return machineRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"))
                .toMachineDto();
    }

}
