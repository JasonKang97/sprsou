package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import pack.model.BoardDaoProcess;

@Controller
public class InsertController {
	@Autowired
	private BoardDaoProcess daoProcess;
	
	@GetMapping("insert")
	public String insertForm() {
		return "insform";
	}
	
	@PostMapping("insert")
	public String insertProcess(BoardBean bean, Model model) {
		// client ip 얻기
		HttpServletRequest request = 
					((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = request.getHeader("X_FORWARDED_FOR");
		if(ip == null) ip = request.getRemoteAddr();
		System.out.println("ip: " + ip);
		bean.setBip(ip);
		bean.setBdate();
		int newNum = daoProcess.currentMaxNum() + 1;	// 새 글 번호
		bean.setNum(newNum);
		bean.setReadcnt(0);
		bean.setGnum(newNum);
		bean.setOnum(0);
		bean.setNested(0);
		
		String str = daoProcess.insert(bean);
		if(str.equals("success")) {
			return "redirect:/list";	// 추가 후 목록 보기
		}
		else {
			model.addAttribute("msg", str);
			return "error";
			//return "forward:/error";
		}
	}
}
