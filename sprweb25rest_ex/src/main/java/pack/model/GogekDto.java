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
public class GogekDto {
    private int gogekno;
    private String gogekname;
	private int gogekdamsano;
	private String gogektel;
    private JikwonDto jikwon;

    public static GogekDto toDto(Gogek gogek) {
        return GogekDto.builder()
                .gogekno(gogek.getGogekno())
                .gogekname(gogek.getGogekname())
                .gogekdamsano(gogek.getGogekdamsano())
                .gogektel(gogek.getGogektel())
                .jikwon(JikwonDto.toDto(gogek.getJikwon()))
                .build();
    }
}