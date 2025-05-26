package pack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{

}
