package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{

	@Query("SELECT j FROM Jikwon j JOIN j.gogeks g WHERE g.gogekno = ?1 AND g.gogekname = ?2")
	Jikwon gogekLogin(int gogekno, String gogekname);
	

}
