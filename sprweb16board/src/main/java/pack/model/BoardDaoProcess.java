package pack.model;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.controller.BoardBean;

@Repository
public class BoardDaoProcess {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardRepository repository;
	
	public Page<Board> listAll(int page){	// 전체 자료 읽기
		// 둘 다 내림차순
		//List<Board> list = repository.findAll(Sort.by(Sort.Order.desc("gnum"), Sort.Order.desc("onum")));
		//List<Board> list = repository.findAll(Sort.by(Sort.Direction.DESC, "gnum", "onum"));
		// 하나는 내림차순
		//List<Board> list = repository.findAll(Sort.by(Sort.Order.desc("gnum"), Sort.Order.asc("onum")));
		
		Sort sort = Sort.by(Sort.Order.desc("gnum"), Sort.Order.asc("onum"));
		Pageable paging = PageRequest.of(page, 10, sort);
		Page<Board> list = repository.findAll(paging);
		
		// JPA는 zero-based 인덱스를 반환하므로 +1을 추가한다.
		System.out.println("page number: " + list.getPageable().getPageNumber()+1);
		System.out.println("page size: " + list.getSize());
		System.out.println("total pages: " + list.getTotalPages());
		System.out.println("total count: " + list.getTotalElements());
		System.out.println("next: " + list.nextPageable());
		
		logger.info("반환된 레코드 수: ", list.getContent().size());
		return list;
	}
	
	public Page<Board> search(BoardBean bean){	// 검색용
		Sort sort = Sort.by(Sort.Order.desc("gnum"), Sort.Order.asc("onum"));
		Pageable paging = PageRequest.of(0, 10, sort);
		Page<Board> slist = null;
		if(bean.getSearchName().equals("name")) {
			slist = repository.searchLike1(paging, bean.getSearchValue());
		}else {
			slist = repository.searchLike2(paging, bean.getSearchValue());
		}
		return slist;
	}
	
	public int currentMaxNum() {	// 새 글 추가 시 num 구하기
		return repository.maxNum();
	}
	
	//@Transactional
	public String insert(BoardBean bean) {
		try {
			Board board = new Board();
			board.setNum(bean.getNum());
			board.setName(bean.getName());
			board.setPass(bean.getPass());
			board.setMail(bean.getMail());
			board.setTitle(bean.getTitle());
			board.setCont(bean.getCont());
			board.setBip(bean.getBip());
			board.setBdate(bean.getBdate());
			board.setReadcnt(bean.getReadcnt());
			board.setGnum(bean.getGnum());
			board.setOnum(bean.getOnum());
			board.setNested(bean.getNested());
			repository.save(board);	// insert into...
			return "success";
		} catch (Exception e) {
			return "insert err: " + e.getMessage();
		}
	}
}
