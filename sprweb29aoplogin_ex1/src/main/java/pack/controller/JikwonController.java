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
	public String jikwonProcess(Model model, HttpServletRequest request, HttpServletResponse response) {
		Jikwon jikwon = (Jikwon) request.getSession().getAttribute("Jikwon");

		if (jikwon != null) {
			model.addAttribute("jlist", jikwon);
		}else {
			List<Jikwon> jlist = dataDao.jikwonListAll();
			model.addAttribute("jlist", jlist);
		}

		return "list";
	}
}
