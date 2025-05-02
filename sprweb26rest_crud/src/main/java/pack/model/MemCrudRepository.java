package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemCrudRepository extends JpaRepository<Mem, Integer>{
	@Query("select max(m.num) from Mem m")
	int findByMaxNum();
	
	@Query("select m from Mem m where m.num=?1")
	Mem findByNum(String num);
}
