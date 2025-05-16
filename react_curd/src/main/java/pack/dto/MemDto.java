package pack.dto;

import org.apache.ibatis.type.Alias;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Alias("memDto")
public class MemDto {
	private int num;
	private String name;
	private String addr;
}
