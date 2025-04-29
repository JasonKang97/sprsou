package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@GetMapping("login")
	public String login(HttpSession session) {
		if(session.getAttribute("idKey") == null) {
			return "redirect:/login.html";
		}else {
			return "redirect:/buserlist";
		}
	}
	
	@PostMapping("login")
	public String login(HttpSession session, @RequestParam("id")String id, @RequestParam("pwd")String pwd) {
		if(id.equals("aa") && pwd.equals("11")) {
			session.setAttribute("idKey", id);
			return "redirect:/buserlist";
		}else {
			return "redirect:/login.html";
		}
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		//session.invalidate();
		session.removeAttribute("idKey");
		return "redirect:/";
	}

}
