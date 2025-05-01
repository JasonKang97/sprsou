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
public class JikwonDto {
    private int jikwonno;
    private String jikwonname;
    private String jikwonjik;
    private BuserDto buser;

    public static JikwonDto toDto(Jikwon jikwon) {
        return JikwonDto.builder()
                .jikwonno(jikwon.getJikwonno())
                .jikwonname(jikwon.getJikwonname())
                .jikwonjik(jikwon.getJikwonjik())
                .buser(BuserDto.toDto(jikwon.getBuser()))
                .build();
    }
}
