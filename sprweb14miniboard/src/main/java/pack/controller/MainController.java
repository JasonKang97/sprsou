package pack.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;

@Controller
public class MainController {
	
	@Autowired
	DataDao dao;
	
	@GetMapping("board")
	public String listProcess(Model model) {
		model.addAttribute("data", dao.getDataAll());
		return "list";
	}
	
	@GetMapping("insert")
	public String insert(Model model) {
		model.addAttribute("now", LocalDateTime.now());
		return "insert";
	}
	
	@PostMapping("insert")
	public String insert(Model model, BoardBean bean) {
		if(dao.insert(bean).equals("success")) {
			return "redirect:board";
		}else{
			model.addAttribute("msg", dao.insert(bean));
			return "error";
		}
	}
	
	@GetMapping("detail")
	public String detail(Model model , @RequestParam("num")int num) {
		dao.updateReadcnt(num);
		model.addAttribute("data", dao.getDataOne(num));
		return "detail";
	}
	
	
	@GetMapping("update")
	public String update(Model model , @RequestParam("num")int num) {
		model.addAttribute("data", dao.getDataOne(num));
		return "update";
	}
	
	@PostMapping("update")
	public String update(Model model, BoardBean bean) {
		if(dao.update(bean).equals("success")) {
			return "redirect:board";
		}else{
			model.addAttribute("msg", dao.insert(bean));
			return "error";
		}
	}
	
	 @GetMapping("delete")
	    public String delete(@RequestParam("num") int num) {
	        String result = dao.delete(num);
	        if(result.equals("success")) {
	            return "redirect:board";
	        } else {
	            return "error";
	        }
	    }
	
	
}
