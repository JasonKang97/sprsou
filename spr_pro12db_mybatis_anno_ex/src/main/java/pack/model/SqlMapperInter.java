package pack.model;

import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	@Select("select jikwonno, jikwonname, nvl(busername, '무소속') busername, DATE_FORMAT(jikwonibsail, '%Y') ibsayear, jikwonpay from jikwon left outer join buser ON busernum=buserno")
	public List<JikwonDto> selectData();

	@Select("SELECT nvl(busername, '무소속') busername, COUNT(*) jikwonsu from jikwon left outer join buser ON busernum=buserno group BY busername")
	public List<JikwonDto> selectBuserInwon();
	
	@Select("SELECT nvl(busername, '무소속') busername, jikwonname, MAX(jikwonpay) maxpay from jikwon left outer join buser ON busernum=buserno group BY busername")
	public List<JikwonDto> selectHighPay();
}
