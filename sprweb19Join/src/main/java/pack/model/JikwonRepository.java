package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{
	@Query("select j from Jikwon j join j.buser b")
	List<Jikwon> findAllWithBuser();
}
