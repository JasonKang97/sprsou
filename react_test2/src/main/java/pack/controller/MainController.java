package pack.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pack.model.BuserDto;
import pack.model.DataDao;
import pack.model.JikwonDto;

@RestController
public class MainController {
	
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("/Buser")
	public ArrayList<BuserDto> buserProcess() {		
		return dataDao.buserList();
	}
	
	@GetMapping("/Jikwon")
	public ArrayList<JikwonDto> jikwonProcess(@RequestParam(name = "busername", required = false) String busername) {
		if(busername==null || busername.equals("")) {
			return dataDao.selectJikwonAll();
		}else {
			return dataDao.selectJikwonByBuser(busername);
		}
			
	}
}
