package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemCrudRepository extends JpaRepository<Mem, Integer>{
	// 레코드 1개 읽기
	@Query(value = "select m from Mem as m where m.num=?1")
	Mem findbyNum(String num);
	
	// num 자동증가 처리를 할 경우 가장 높은 번호 찾기 - Max 집계함수를 사용할 수는 없다. >>> JPQL 필요
	//@Query(value = "select m from Mem as m where m.num=(select max(m2.num) from Mem m2)")
	//@Query(value = "select max(m.num) from Mem as m")	// JPQL
	//@Query(value = "select max(num) from mem", nativeQuery = true)	// SQL
	//int findByMaxNum();
}
