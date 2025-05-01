package pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pack.model.DataDao;
import pack.model.GogekDto;
import pack.model.JikwonDto;

@RestController
public class MainController {
	@Autowired
	private DataDao dataProcess;

	@PostMapping("search")
	public Map<String, Object> gogekList(@RequestBody Map<String, Object> noAndName) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		int jikwonno = Integer.parseInt(noAndName.get("jikwonno").toString());
		String jikwonname = noAndName.get("jikwonname").toString();
		JikwonDto jikwonDto = dataProcess.findJikwonDtoByNoAndName(jikwonno, jikwonname);

		if (jikwonDto != null) {
			List<GogekDto> list = dataProcess.findGogekByGogekdamsano(jikwonno);
			result.put("datas", list);
		} else {
			result.put("error", "해당 직원이 없습니다.");
		}
		return result;
	}
}
