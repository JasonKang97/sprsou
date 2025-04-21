package pack.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JikwonRepository extends JpaRepository<JikwonDto, String>{
	List<JikwonDto> findByJikwonjikContaining(String jikwonjik);

}
