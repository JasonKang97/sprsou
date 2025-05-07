package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import pack.model.DataDao;
import pack.model.Jikwon;

@Controller
public class LoginController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("login")
	public String loginProcess(HttpSession httpSession, @RequestParam("no")String no, @RequestParam("name")String name) {
		// no, name을 SQL처리, no만으로 SQL 두가지 방식 모두 처리 가능.
		Jikwon jikwon = dataDao.jikwonLogin(no);	// no만 사용
		
		if(jikwon!=null && name.equals(jikwon.getJikwonname())) {
			httpSession.setAttribute("nameok", name);	// 로그인 성공
		}
		return "redirect:/jikwonlist";
	}
	
	@GetMapping("logout")
	public String logoutProcess(HttpSession httpSession) {
		httpSession.removeAttribute("nameok");
		return "redirect:/";
	}
	
	
}
