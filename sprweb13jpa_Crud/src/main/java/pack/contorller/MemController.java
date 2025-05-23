package pack.contorller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("insert")
	public String insertProcess() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insertProcess(Model model, MemBean bean) {
		String msg = dataProcess.insert(bean);
		
		if(msg.equals("success")) {
			return "redirect:/list";
		}else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
	
	@GetMapping("update")
	public String updateProcess(@RequestParam("num")String num, Model model) {
		Mem mem = dataProcess.getData(num);
		model.addAttribute("data", mem);
		return "update";
	}
	
	@PostMapping("update")
	public String updateProcess(Model model, MemBean bean) {
		String msg = dataProcess.update(bean);
		
		if(msg.equals("success")) {
			return "redirect:/list";	// 수정 후 목록보기
		}else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
	
	@GetMapping("delete")
	public String deleteProcess(@RequestParam("num")int num, Model model) {
		String msg = dataProcess.delete(num);	
		if(msg.equals("success")) {
			return "redirect:/list";	// 수정 후 목록보기
		}else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
}
