package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemDataProcess;
import pack.model.MemDto;

@Controller
public class MemController {
	// 모델 클래스를 포함관계로 기술
	
	@Autowired
	public MemDataProcess dataProcess;
	
	@GetMapping("/memlist")
	public String listProcess(Model model) {
		ArrayList<MemDto> list = (ArrayList<MemDto>)dataProcess.getDataAll();
		model.addAttribute("data", list);
		return "list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("/insert")	// insert, update, delete 후에는 redirect를 사용해야한다.
	public String insertMem(MemBean bean) {
		boolean b = dataProcess.insert(bean);
		if(b) return "redirect:http://localhost/memlist";
		else return "redirect:http://localhost/error.html";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("num")String num, Model model) {
		MemDto memDto = dataProcess.getData(num);
		model.addAttribute("data", memDto);
		return "update";
	}
	
	@PostMapping("/update")
	public String updateMem(MemBean bean) {
		boolean b = dataProcess.update(bean);
		if(b) return "redirect:/memlist";
		else return "redirect:/error.html";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("num")String num, Model model) {
		boolean b = dataProcess.delete(num);
		if(b) return "redirect:/memlist";
		else return "redirect:/error.html";
	}
}
