package pack.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.model.DataDao;
import pack.model.Jikwon;

@Controller
public class JikwonController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("jikwonlist")
	// AOP 로그인 처리시 pointcut 대상 메소드는 HttpServletRequest와 HttpServletResponse가 반드시 있어야 한다.
	public String jikwonProcess(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<Jikwon> jlist = dataDao.jikwonListAll();
		model.addAttribute("jlist", jlist);
		return "jikshow";
	}
	
}
