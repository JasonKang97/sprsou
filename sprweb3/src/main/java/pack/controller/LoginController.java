package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("login")
	public String loginGet() {
		return "redirect:http://localhost/login.html";
	}
	
	@PostMapping("login")
	public String loginPost(@RequestParam("id") String id, @RequestParam("pwd") String pwd, Model model) {
		String data;
		if(id.equals("aa") && pwd.equals("123")) {
			data="redirect:http://localhost/input.html";
		}else {
			data="redirect:http://localhost/loginfail.html";
		}
		
		return data;
	}
}
