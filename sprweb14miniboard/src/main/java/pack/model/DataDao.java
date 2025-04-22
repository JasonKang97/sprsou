package pack.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository
public class DataDao {
	
	@Autowired
	BoardCrudRepository repository;
	
	public List<BoardDto> getDataAll(){
		 List<BoardDto> list = repository.findAll();
		 return list;
	}
		
	public String insert(BoardBean bean){
		try {
			BoardDto dto = new BoardDto();
			dto.setTitle(bean.getTitle());
			dto.setAuthor(bean.getAuthor());
			dto.setContent(bean.getContent());
			dto.setBwrite(bean.getBwrite());
			dto.setReadcnt("0");
			repository.save(dto);
			return "success";
		} catch (Exception e) {
			return "error 사유: " + e;
		}
	}
	
	public BoardDto getDataOne(int num){
		 BoardDto dto = repository.findById(num).get();
		 return dto;
	}
	
	public String update(BoardBean bean){
		try {
			BoardDto dto = new BoardDto();
			dto.setNum(bean.getNum());
			dto.setTitle(bean.getTitle());
			dto.setAuthor(bean.getAuthor());
			dto.setContent(bean.getContent());
			dto.setBwrite(bean.getBwrite());
			dto.setReadcnt(bean.getReadcnt());
			repository.save(dto);
			return "success";
		} catch (Exception e) {
			return "error 사유: " + e;
		}
	}
	
	public void updateReadcnt(int num) {
		BoardDto dto = repository.findById(num).orElse(null);
		if (dto != null) {
			int currentCnt = Integer.parseInt(dto.getReadcnt());
			dto.setReadcnt(String.valueOf(currentCnt + 1));
			repository.save(dto);
		}
	}
	
	 public String delete(int num) {
	        try {
	            repository.deleteById(num);
	            return "success";
	        } catch (Exception e) {
	            return "error: " + e.getMessage();
	        }
	    }
}
