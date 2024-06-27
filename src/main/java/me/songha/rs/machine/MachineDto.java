package me.songha.rs.machine;

import lombok.Builder;
import lombok.Data;
import me.songha.rs.businesslocation.BusinessLocationDto;

import java.time.LocalDateTime;

@Builder
@Data
public class MachineDto {
    private Long id;
    private BusinessLocationDto businessLocationDto;
    private String machine_name;
    private String machine_type;
    private String manufacturer;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Machine toEntity() {
        return Machine.builder()
                .id(this.id)
                .machine_name(this.machine_name)
                .machine_type(this.machine_type)
                .businessLocation(this.businessLocationDto.toEntity())
                .manufacturer(this.manufacturer)
                .build();
    }
}
