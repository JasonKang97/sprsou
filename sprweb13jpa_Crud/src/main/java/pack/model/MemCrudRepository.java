package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemCrudRepository extends JpaRepository<Mem, Integer>{
	// 레코드 1개 읽기
	@Query(value = "select m from Mem as m where m.num=?1")
	Mem findbyNum(String num);
}
