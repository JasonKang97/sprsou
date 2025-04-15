package pack.model;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class SangpumImpl implements SangpumInter{
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	
	@Override
	public List<SangpumDto> selectList() {
		SqlSession sqlSession = factory.openSession();
		List<SangpumDto> list = null;
		SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
		
		try {
			list = mapperInter.selectAll();
		} catch (Exception e) {
			System.out.println("selectList err: " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return list;
	}
}
