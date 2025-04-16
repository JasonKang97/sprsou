package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.SangpumModel;

@Controller
public class InputController {
	@Autowired
	private SangpumModel sangpumModel;
	
	@GetMapping("insdata")
	public String aaa() {
		return "redirect:http://localhost:80/input.html";
	}
	
	@PostMapping("insdata")
	public String bbb(SangpumBean bean, Model model) {
		model.addAttribute("data", sangpumModel.computePrice(bean));
		return "result";
	}
}
