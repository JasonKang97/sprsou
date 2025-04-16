package pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	// log 정보 풀력
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("login")
	public String submitcall() {
		
		return "redirect:http://localhost/login.html";	// redirect 방식. Spring은 기본적으로 forward 방식을 사용.
	}
	/*
	// 방법1: 전통적 방식으로 클라이언트로부터 값 받기
	@PostMapping("login")
	public String submit(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id + " " + pwd);
		logger.info(id + " " + pwd);
		
//		아래로 내려갈수록 높은 레벨입니다. 
//		1. trace: debug레벨보다 더 상세한 정보를 표시
//		2. debug: 디버깅을 위한 정보를 표시
//		3. info: 정보성 로그를 표시
//		4. warn: 시스템 에러의 원인이 될 수 있는 경고성 메시지를 표시
//		5. error: 요청을 처리하는 중 오류가 발생한 경우 표시
		
		String data = "";
		if(id.equals("aa") && pwd.equals("11")) {
			data = "로그인 성공";
		}else {
			data = "로그인 실패";
		}
		
		model.addAttribute("data", data);
		
		return "result";	// forward 방식.
	}
	*/
	
	// 방법2: Spring 방식으로 클라이언트로부터 값 받기	>>>	login?id=값&pwd=값2
	@PostMapping("login")
	public String submit(@RequestParam(value = "id",defaultValue = "tom")String id,
			@RequestParam("pwd")String pwd,
			//@RequestParam("pwd")int pwd,	>>>	형변환이 가능하다.
			Model model) {
		String data;
		if(id.equals("aa") && pwd.equals(11)) {
			data = "로그인 성공";
		}else {
			data = "로그인 실패";
		}
		model.addAttribute("data", data);
		logger.info(id + " " + pwd);
		return "result";
	}
}
