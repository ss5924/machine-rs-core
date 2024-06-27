package me.songha.rs.machine;

import jakarta.persistence.*;
import lombok.*;
import me.songha.rs.businesslocation.BusinessLocation;
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
@Table(name = "machine")
public class Machine implements Serializable {
    @Serial
    private static final long serialVersionUID = 8618306483779969709L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "business_location_id")
    private BusinessLocation businessLocation;

    private String machine_name;
    private String machine_type;
    private String manufacturer;

    @CreatedDate
    private LocalDateTime createAt;
    @LastModifiedDate
    private LocalDateTime updateAt;

    @Builder
    public Machine(Long id, BusinessLocation businessLocation, String machine_name, String machine_type, String manufacturer) {
        this.id = id;
        this.businessLocation = businessLocation;
        this.machine_name = machine_name;
        this.machine_type = machine_type;
        this.manufacturer = manufacturer;
    }

    public MachineDto toMachineDto() {
        return MachineDto.builder()
                .id(this.id)
                .machine_name(this.machine_name)
                .businessLocationDto(this.businessLocation.toBusinessLocationDto())
                .machine_type(this.machine_type)
                .manufacturer(this.manufacturer)
                .createAt(this.createAt)
                .updateAt(this.updateAt)
                .build();
    }
}
