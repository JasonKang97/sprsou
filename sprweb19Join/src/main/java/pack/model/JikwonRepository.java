package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer>{
	// inner join
	@Query("select j from Jikwon j join j.buser b order by jikwonno")
	List<Jikwon> findAllWithBuser();
	
	// 조건부 join: 직원의 연봉이 5000 이상
	@Query("select j from Jikwon j join j.buser b where cast(j.jikwonpay as int)>=5000 order by jikwonno")
	List<Jikwon> findAllWithHighPay();
	
	// 조건부 join: 특정 부서명으로 조인
	@Query("select j from Jikwon j join j.buser b where b.busername=:buserName order by jikwonno")
	List<Jikwon> findAllBuserName(@Param("buserName")String buserName);
	
	// left join: jikwon은 모두 나오고 buser는 없는 경우 null
	@Query("select j from Jikwon j left join j.buser b")
	List<Jikwon> findAllBuserLeftJoin();
	
	// left join: buser는 모두 나오고 jikwon은 없는 경우 null
	@Query("select j from Jikwon j right join j.buser b")
	List<Jikwon> findAllBuserRightJoin();
	
	// fetch join: join과 유사하나 JPA에서는 연관된 Entity를 즉시 로딩할 수 있도록 fetch 사용
	@Query("select j from Jikwon j join fetch j.buser b")
	List<Jikwon> findAllBuserFetch();
	
	// native query
	@Query(value = "select * from Jikwon j join j.buser b on j.busernum=b.buserno", nativeQuery=true)
	List<Jikwon> findAllBuserNative();
	
	// subquery: 가장 높은 연봉을 받는 직원 조회를 서브쿼리로 작성
	@Query("select j from Jikwon j where j.jikwonpay=(select max(j2.jikwonpay) from Jikwon j2)")
	List<Jikwon> findTopPaidJikwon();

	// 다중 조건 join
	@Query("select j from Jikwon j join j.buser b where b.busername=:buserName and j.jikwonpay>:minPay")
	List<Jikwon> findJikwonByBuserNameAndMinPay(@Param("buserName")String buserName, @Param("minPay")String minPay);
}