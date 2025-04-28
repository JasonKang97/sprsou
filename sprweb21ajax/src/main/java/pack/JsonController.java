package pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {
	@Autowired
	private MyModel myModel;
	
	@GetMapping("list")
	@ResponseBody	// 반환 객체를 Http 응답 객체로 전송. 문자열 또는 Json 형식의 결과가 반환
	public MyModel getJson(@RequestParam("name")String name) {
		myModel.setName(name);
		myModel.setSkills(new String[] {"자바 개발자", "웹 개발자"});
		return myModel;
	}
	
	@GetMapping("list2")
	@ResponseBody
	public Map<String, Object> getJson2() {
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("name", "홍길동");
		data.put("age", "33");
		dataList.add(data);
		
		data = new HashMap<String, Object>();
		data.put("name", "고길동");
		data.put("age", "31");
		dataList.add(data);
		
		data = new HashMap<String, Object>();
		data.put("name", "김길동");
		data.put("age", "34");
		dataList.add(data);
		
		Map<String, Object> data2 = new HashMap<String, Object>();
		data2.put("datas", dataList);
		return data2;
	}
}
