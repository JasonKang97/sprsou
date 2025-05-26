package pack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GogekRepository extends JpaRepository<Gogek, Integer>{

}
