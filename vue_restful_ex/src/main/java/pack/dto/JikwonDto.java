package pack.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("jikwonDto")
public class JikwonDto {
	private int jikwonno;
	private String jikwonname;
	private String jikwonjik;
	private String busername;
}
