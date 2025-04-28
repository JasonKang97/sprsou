package pack.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.model.DataProcess;
import pack.model.GogekDto;
import pack.model.Jikwon;

@Controller
public class MainController {
	@Autowired
	private DataProcess dataProcess;
	
	
	@GetMapping("/")
	public String jikwonList(Model model) {
		List<Jikwon> list = dataProcess.getJikwonListAll();
		model.addAttribute("list", list);
		return "jikwonlist";
	}
	
	@GetMapping("gogeklist")
	public String gogekList(Model model, @RequestParam("jikwonname")String jikwonname,
			@RequestParam("jikwonjik")String jikwonjik) {
		List<GogekDto> list = dataProcess.getGogekListAll(jikwonname);
		model.addAttribute("list", list);
		model.addAttribute("jikwonname", jikwonname);
		model.addAttribute("jikwonjik", jikwonjik);
		return "gogeklist";
	}
}
