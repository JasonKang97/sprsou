package pack;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyErrController implements ErrorController{
	 @GetMapping("/error")
	 public String handleError(HttpServletRequest request) {
		 return "redirect:/login";
	 }
}
