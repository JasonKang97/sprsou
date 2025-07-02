package pack.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
	// 추가적인 쿼리 메소드 선언
	Customer findByName(String name);
}
