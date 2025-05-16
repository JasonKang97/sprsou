package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapperInterface {
	@Select("SELECT b.buserno, b.busername, b.busertel, COUNT(j.jikwonno) AS count FROM buser b"
			+ " LEFT JOIN jikwon j ON b.buserno = j.busernum GROUP BY b.buserno, b.busername, b.busertel ORDER BY b.buserno")
	List<BuserDto> buserList();
	
	@Select("SELECT jikwon.jikwonno, jikwon.jikwonname, buser.busername, jikwon.jikwonjik, jikwon.jikwonpay, COUNT(gogek.gogekno) as count from jikwon"
			+ " JOIN buser ON jikwon.busernum = buser.buserno LEFT JOIN gogek ON gogek.gogekdamsano=jikwon.jikwonno"
			+ " where buser.busername=#{busername} GROUP BY jikwon.jikwonno,jikwon.jikwonname,buser.busername,jikwon.jikwonjik")
	List<JikwonDto> selectJikwonByBuser(String busername);
	
	@Select("SELECT jikwon.jikwonno, jikwon.jikwonname, buser.busername, jikwon.jikwonjik, jikwon.jikwonpay, COUNT(gogek.gogekno) as count from jikwon"
			+ " JOIN buser ON jikwon.busernum = buser.buserno LEFT JOIN gogek ON gogek.gogekdamsano=jikwon.jikwonno"
			+ " GROUP BY jikwon.jikwonno,jikwon.jikwonname,buser.busername,jikwon.jikwonjik")
	List<JikwonDto> selectJikwonAll();
	
}
