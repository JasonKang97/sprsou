package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.DataDao;
import pack.model.SangpumDto;

@Controller
public class TestController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("sangpums")
	@ResponseBody
	public Map<String, Object> abc() {
		// 선택적으로 데이터를 골라 넘길 경우 이 방법을 사용
		/*
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		
		for(SangpumDto s:dataDao.getSangpumAll()) {
			data = new HashMap<String, String>();
			data.put("code", String.valueOf(s.getCode()));
			data.put("sang",s.getSang());
			data.put("su", s.getSu());
			data.put("dan", s.getDan());
			list.add(data);
		}
		*/
		
		// 모든 데이터를 넘길 경우 이 방법을 사용
		List<SangpumDto> list = dataDao.getSangpumAll();
		Map<String, Object> sangList = new HashMap<String, Object>();
		sangList.put("datas", list);
		return sangList;
	}
}
