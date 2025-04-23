package pack.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	// 전체 자료 읽기(num별 내림차순, 페이지 나누기)
	Page<Board> findByOrderByNumDesc(Pageable pageable);
	
	// 검색용 JPQL
	@Query("select b from Board b where b.name like %?1%")	// name별 검색, 순서로 매핑
	Page<Board> searchLike1(Pageable pageable, String searchValue);
	
	@Query("select b from Board b where b.title like %:searchValue%")	// title별 검색, 이름로 매핑
	Page<Board> searchLike2(Pageable pageable, @Param("searchValue")String searchValue);
	
	// 추가용 가장 큰 num 읽기
	@Query("select max(b.num) from Board b")
	int maxNum();
}
