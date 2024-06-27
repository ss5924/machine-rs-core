package me.songha.rs.vendor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class VendorDto {
    private Long id;
    private String vendorName;
    private String vendorAddress;
    private String vendorFax;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createAt;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateAt;

    @JsonCreator
    public VendorDto(
            @JsonProperty("id") Long id,
            @JsonProperty("vendorName") String vendorName,
            @JsonProperty("vendorAddress") String vendorAddress,
            @JsonProperty("vendorFax") String vendorFax,
            @JsonProperty("createAt") LocalDateTime createAt,
            @JsonProperty("updateAt") LocalDateTime updateAt) {
        this.id = id;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorFax = vendorFax;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Vendor toEntity() {
        return Vendor.builder()
                .id(this.id)
                .vendorAddress(this.vendorAddress)
                .vendorFax(this.vendorFax)
                .vendorName(this.vendorName)
                .build();
    }

}
