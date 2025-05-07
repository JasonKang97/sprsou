package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{
	// JPQL
	//@Query("select j from Jikwon j where jikwonno=?1")	// 위치 매핑
	//Jikwon jikwonLogin(String jikwonno);
	
	@Query("select j from Jikwon j where jikwonno=:jikwonno")	// 이름 매핑
	Jikwon jikwonLogin(@Param("jikwonno") String jikwonno);
}
