package me.songha.rs.businesslocation;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class BusinessLocationDto {
    private Long id;
    private String businessLocationName;
    private String businessLocationAddress;
    private String businessLocationType;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public BusinessLocation toEntity() {
        return BusinessLocation.builder()
                .id(this.id)
                .businessLocationAddress(this.businessLocationAddress)
                .businessLocationName(this.businessLocationName)
                .businessLocationType(this.businessLocationType)
                .build();
    }
}
