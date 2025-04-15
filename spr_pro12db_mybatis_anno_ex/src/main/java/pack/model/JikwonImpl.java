package pack.model;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter{
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	
	@Override
	public List<JikwonDto> selectData() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
		
		try {
			list = mapperInter.selectData();
		} catch (Exception e) {
			System.out.println("selectList err: " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	
	@Override
	public List<JikwonDto> selectBuserInwon() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
		
		try {
			list = mapperInter.selectBuserInwon();
		} catch (Exception e) {
			System.out.println("selectBuserInwon err: " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	
	@Override
	public List<JikwonDto> selectHighPay() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
		
		try {
			list = mapperInter.selectHighPay();
		} catch (Exception e) {
			System.out.println("selectHighPay err: " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
}
