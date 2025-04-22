package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCrudRepository extends JpaRepository<BoardDto, Integer>{
	
}
