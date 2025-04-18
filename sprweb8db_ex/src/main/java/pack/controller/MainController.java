package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class MainController {
	
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("jik")
	public String listProcess(Model model, @RequestParam("jikwonjik")String jikwonjik) {
		ArrayList<JikwonDto> list = dataDao.selectJik(jikwonjik);
		model.addAttribute("list", list);
		return "list";
	}
}
