package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GogekRepository extends JpaRepository<Gogek, Integer>{
	public List<Gogek> findByGogekdamsano(int gogekdamsano);
}
