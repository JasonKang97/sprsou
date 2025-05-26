package pack.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.ProductDto;

@Repository
public class ProductProcess {
	@Autowired
	private SqlSession sqlSession;
	
	public List<ProductDto> getAll(){
		return sqlSession.selectList("product.getAll");
	}
	
	public ProductDto getData(String code){
		return sqlSession.selectOne("product.getData", code);
	}
	
	public void insert(ProductDto dto){
		sqlSession.insert("product.insert", dto);
	}
	
	public void update(ProductDto dto){
		sqlSession.update("product.update", dto);
	}
	
	public void delete(String code){
		sqlSession.delete("product.delete", code);
	}
}
