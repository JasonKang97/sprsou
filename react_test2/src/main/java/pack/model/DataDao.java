package pack.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	
	@Autowired
	private DataMapperInterface dataMapperInterface;
	
	public ArrayList<BuserDto> buserList(){
		ArrayList<BuserDto> list= (ArrayList<BuserDto>)dataMapperInterface.buserList();
		return list;
	}
	
	public ArrayList<JikwonDto> selectJikwonByBuser(String busername){
		ArrayList<JikwonDto> list= (ArrayList<JikwonDto>)dataMapperInterface.selectJikwonByBuser(busername);
		return list;
	}
	
	public ArrayList<JikwonDto> selectJikwonAll(){
		ArrayList<JikwonDto> list= (ArrayList<JikwonDto>)dataMapperInterface.selectJikwonAll();
		return list;
	}
	
}
