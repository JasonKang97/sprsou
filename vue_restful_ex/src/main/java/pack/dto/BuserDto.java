package pack.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("buserDto")
public class BuserDto {
	private int buserno;
	private String busername;
	private String buserloc;
	private String busertel;
}
