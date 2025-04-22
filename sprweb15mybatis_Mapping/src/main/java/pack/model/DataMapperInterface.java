package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataMapperInterface {
	// 추상 메소드의 이름은 Mapper.xml의 id명과 일치시킨다.
	List<Board> selectDataAll();
	
}
