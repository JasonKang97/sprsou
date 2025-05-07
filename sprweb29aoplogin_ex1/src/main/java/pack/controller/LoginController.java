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
	public String login() {
		return "redirect:/jikwonlist";
	}
	
	@PostMapping("login")
	public String loginProcess(HttpSession httpSession, @RequestParam(name = "gogekno", defaultValue = "0") int gogekno,
														@RequestParam(name = "gogekname", defaultValue = "") String gogekname) {
		Jikwon jikwon = dataDao.gogekLogin(gogekno, gogekname);
		httpSession.setAttribute("Jikwon", jikwon);

		return "redirect:/jikwonlist";
	}
}
