package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.ScoreBean;
import pack.model.ScoreModel;

@Controller
public class InputController {
	@Autowired
	public ScoreModel scoreModel;
	
	@PostMapping("display")
	public String bbb(ScoreBean bean, Model model) {
		model.addAttribute("data", scoreModel.score(bean));
		return "result";
	}
}
