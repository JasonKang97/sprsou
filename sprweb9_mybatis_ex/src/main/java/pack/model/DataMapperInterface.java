package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapperInterface {
	@Select("select * from jikwon where jikwonjik=#{jikwonjik}")
	List<JikwonDto> selectJikwonjik(String jikwonjik);
	
	@Select("select * from jikwon")
	List<JikwonDto> selectAll();
}
