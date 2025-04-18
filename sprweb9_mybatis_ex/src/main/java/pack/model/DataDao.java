package pack.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	
	@Autowired
	private DataMapperInterface dataMapperInterface;
	
	public ArrayList<JikwonDto> selectJikwonjik(String jikwonjik){
		ArrayList<JikwonDto> list= (ArrayList<JikwonDto>)dataMapperInterface.selectJikwonjik(jikwonjik);
		return list;
	}
	
	public ArrayList<JikwonDto> selectAll(){
		ArrayList<JikwonDto> list= (ArrayList<JikwonDto>)dataMapperInterface.selectAll();
		return list;
	}
}
