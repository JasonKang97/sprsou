package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuserDto {
    private int buserno;
    private String busername;
    private String busertel;

    public static BuserDto toDto(Buser buser) {
        return BuserDto.builder()
                .buserno(buser.getBuserno())
                .busername(buser.getBusername())
                .busertel(buser.getBusertel())
                .build();
    }
}