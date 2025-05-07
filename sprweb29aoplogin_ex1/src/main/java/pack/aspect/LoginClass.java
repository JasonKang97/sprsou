package pack.aspect;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginClass {
	public boolean loginCehck(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("nameok") == null) {
			response.sendRedirect("login");
			return true;
		}else {
			return false;
		}
	}
}
