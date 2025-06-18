package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class TestController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(name="userid")String userid, @RequestParam(name="password")String password, HttpSession httpSession, Model model) {
		String validid = "ok";
		String validpassword = "123";
		
		if(userid.equals(validid) && password.equals(validpassword)) {
			httpSession.setAttribute("user", userid);
			return "redirect:/success";
		}else {
			model.addAttribute("error", "잘못된 id 또는 password 입력");
			return "login";
		}
	}
	
	@GetMapping("/success")
	public String success(HttpSession httpSession, Model model) {
		String user = (String)httpSession.getAttribute("user");
		
		if(user != null) {
			model.addAttribute("myuser", user);
			return "success";
		}else {
			return "redirect:/login";
		}
		
	}
		
	@GetMapping("/gugu")
	public String gugu(HttpSession httpSession) {
		if(httpSession.getAttribute("user") != null) {
			return "gugu";
		}else {
			return "redirect:/login";
		}
	}
	
	@PostMapping("/gugu")
	public String gugu(@RequestParam(name="num")int num, HttpSession httpSession, Model model) {
		if(httpSession.getAttribute("user") != null) {
			model.addAttribute("num", num);
			return "guguresult";
		}else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession httpSession, HttpServletResponse response) {
		httpSession.removeAttribute("user");
		Cookie cookie = new Cookie("JSESSIONID", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "redirect:/login";
	}
	
}
