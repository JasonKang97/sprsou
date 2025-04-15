package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface{
	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();	// CRUD 수행 관리
		EntityTransaction tx = em.getTransaction();	// 트랜젝션을 관리하는 인터페이스
		
		List<MemDto> list = null;
		try {
			// 레코드 1개 조회
			MemDto mdto = em.find(MemDto.class, 1);	// 내부적으로 sql문 수행됨.(select문)
			System.out.println(mdto.getNum() + " " + mdto.getName() + " " + mdto.getAddr());
			
			// 전체 자료 얻기
			list = findAll(em, MemDto.class);
			
		} catch (Exception e) {
			System.out.println("selectDataAll err: " + e);
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
		return list;
	}
	
	public List findAll(EntityManager em, Class cla){
		// JPQL: JPA는 SQL을 추상화한 JPQL이라는 객체 지향 쿼리 언어를 제공한다.
		return em.createQuery("select e from " + cla.getName() + " e", cla).getResultList();
	}
}
