package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController3 {
	@RequestMapping("/java/korea")
	public String ghi1(Model model) {
		model.addAttribute("msg", "/java/korea 처리 완료");
		return "list";
	}
	
	@GetMapping({"/java/good", "ok", "hello"})
	public String ghi2(Model model) {
		model.addAttribute("msg", "/java/good 처리 완료");
		return "list";
	}

}
