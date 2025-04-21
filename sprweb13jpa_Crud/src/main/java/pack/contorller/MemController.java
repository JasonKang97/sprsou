package pack.contorller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataProcess;
import pack.model.Mem;

@Controller
public class MemController {
	
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("list")
	public String listProcess(Model model) {
		ArrayList<Mem> list = (ArrayList<Mem>)dataProcess.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
}
