package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	@GetMapping("/user/required_loginform")
	public String required_form() {
		return "user/required_loginform";
	}
	
	@GetMapping("/user/loginform")
	public String loginform() {
		return "user/loginform";
	}
	
	@PostMapping("/user/login_success")
	public String login_success() {
		return "user/login_success";
	}
	
	@PostMapping("/user/login_fail")
	public String login_fail() {
		return "user/login_fail";
	}
	
	@GetMapping("/user/denied")
	public String denied() {
		return "user/denied";
	}
	
	@GetMapping("/staff/user/list")
	public String userlist() {
		return "user/list";
	}
	
	@GetMapping("/admin/user/manage")
	public String usermanage() {
		return "user/manage";
	}
	
	@GetMapping("/user/expired")
	public String userexpired() {
		return "user/expired";
	}
}
