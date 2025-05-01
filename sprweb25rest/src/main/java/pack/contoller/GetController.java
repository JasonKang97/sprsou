package pack.contoller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController		// @Controller과 @ResponseBody를 합친 annotation
public class GetController {
	@GetMapping("hello")
	public String abc() {
		System.out.println("요청1 접수");
		return "Hello";
	}
	
	@GetMapping("/hello/{info}")
	public String abc2(@PathVariable("info")String info) {
		System.out.println("요청2 접수");
		return info;
	}
	
	@GetMapping("/world")
	public String abc3(@RequestParam("name")String irum, @RequestParam("age")String nai) {
		System.out.println("요청3 접수");
		return irum + nai;
	}
}
