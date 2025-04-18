package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataMapperInterface {
	@Select("select * from sangdata")
	List<SangpumDto> selectAll();
	
	@Select("select * from sangdata where sang like concat('%',#{searchValue},'%')")
	List<SangpumDto> selectSearch(String searchValue);
	
	// MariaDB: where sang like concat('%',#{searchValue},'%')
	// Oracle: where sang like '%'||#{searchValue}||'%'
}
