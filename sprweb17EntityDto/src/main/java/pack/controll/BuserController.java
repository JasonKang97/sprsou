package pack.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.BuserDto;
import pack.model.DataProcess;

@Controller
public class BuserController {
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		List<BuserDto> list = dataProcess.getDataAll();
		model.addAttribute("data", list);
		return "list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("/insert")
	public String insertProcess(BuserBean bean, Model model) {		
		try {
			String result = dataProcess.insert(bean);
			if(result.equals("success")) {
				return "redirect:/list";
			}else {
				model.addAttribute("msg", result);
				return "error";
			}
				
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "error";
		}
		
	
	}
}
