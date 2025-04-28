package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GogekRepository extends JpaRepository<Gogek, Integer>{
	@Query("select g from Gogek g join jikwon on gogekdamsano=jikwonno where jikwonname=:jikwonname")
	public List<Gogek> gogekList(@Param("jikwonname")String jikwonname);
}
