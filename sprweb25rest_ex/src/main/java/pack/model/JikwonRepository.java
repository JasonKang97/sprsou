package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{
	public Jikwon findByJikwonnoAndJikwonname(int jikwonno, String jikwonname);
}
