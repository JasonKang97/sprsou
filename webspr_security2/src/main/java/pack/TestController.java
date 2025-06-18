package pack;

import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TestController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	// Authentication: 현재 로그인한 사용자 관련 정보를 담고 있다.
	// authentication.getAuthorities()를 통해 사용자가 가진 역할을 읽어 온다.
	@GetMapping("/default")
	public void defaultAfterLogin(Authentication authentication, HttpServletResponse response) throws IOException{
		for(GrantedAuthority authority:authentication.getAuthorities()) {
			String role = authority.getAuthority();		// 특정 권한(ROLE)을 문자열로 반환
			
			if(role.equals("ROLE_ADMIN")) {
				response.sendRedirect("/admin");		//  ADMIN 역할이면 /admin 요청이 이루어진다.
				return;
			}else if(role.equals("ROLE_USER")) {
				response.sendRedirect("/user");			//  USER 역할이면 /user 요청이 이루어진다.
				return;
			}else if(role.equals("ROLE_JAMES")) {
				response.sendRedirect("/james");		//  JAMES 역할이면 /james 요청이 이루어진다.
				return;
			}
		}
		
		response.sendRedirect("/common");		// 그 외의 경우 /common 요청이 이루어짐
	}
	
	@GetMapping("/admin")
	public String adminLogin(Model model) {
		model.addAttribute("msg", "관리자 권한");
		return "commonshow";
	}
	
	@GetMapping("/user")
	public String userLogin(Model model) {
		model.addAttribute("msg", "일반사용자 권한");
		return "commonshow";
	}
	
	@GetMapping("/james")
	public String jamesLogin(Model model) {
		model.addAttribute("msg", "james 권한");
		return "commonshow";
	}
	
	@GetMapping("/common")
	public String commonLogin(Model model) {
		model.addAttribute("msg", "모두에게 허용된 페이지");
		return "commonshow";
	}
	
	
}
