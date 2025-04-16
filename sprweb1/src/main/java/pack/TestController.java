package pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pack.good.DataVo;

@Controller	// 객체 생성. 사용자의 요청 처리한 후 지정된 view에 모델 객체를 넘겨주는 역할
public class TestController {

    private DataVo dataVo;

    TestController(DataVo dataVo) {
        this.dataVo = dataVo;
    }
	@RequestMapping("test1")	// 클라이언트의 요청과 매핑 - 내부에서 ViewResolver 수행
	public ModelAndView abc() {
		String msg = "첫번째 요청 처리 성공";	// 모델을 통해 결과를 얻었다고 가정
		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("list");
//		modelAndView.addObject("msg", msg);	// jsp에서 request.setAttribute("msg", msg);와 동일		
//		return modelAndView;
		return new ModelAndView("list", "msg", msg);	// view 파일명, key, value
	}
	
	@RequestMapping(value = "test2", method = RequestMethod.GET)
	public ModelAndView abc2() {
		return new ModelAndView("list", "msg", "성공2");	// view 파일명, key, value
	}
	
	//@GetMapping(value = "test3")
	@GetMapping(value = {"test3", "testgood", "nice"})	// 다중으로 지정 가능
	public ModelAndView abc3() {
		return new ModelAndView("list", "msg", "성공3");	// view 파일명, key, value
	}
	
	@GetMapping(value = "test4")
	public String abc4(Model model) {
		model.addAttribute("msg", "성공4");
		return "list";	// 파일명
	}
	
	@RequestMapping(value = "test5", method = RequestMethod.POST)
	public ModelAndView abc5() {
		return new ModelAndView("list", "msg", "성공5");	// view 파일명, key, value
	}
	
	@PostMapping(value = "test6")
	public ModelAndView abc6(Model model) {
		return new ModelAndView("list", "msg", "성공6");	// view 파일명, key, value
	}
	
	@PostMapping(value = "test7")
	public String abc7(Model model) {
		model.addAttribute("msg", "성공7");
		return "list";	// 파일명
	}
	
	@GetMapping("test8")
	@ResponseBody	// 서버가 준 값 그대로 클라이언트에게 전달
	public String abc8() {
		String value = "일반 데이터 - String, Map, JSON 등을 전달";
		return value;
	}
	
	@GetMapping("test8_1")
	@ResponseBody	// 서버가 준 값 그대로 클라이언트에게 전달
	public DataVo abc8_1() {
		DataVo dataVo = new DataVo();
		dataVo.setCode(10);
		dataVo.setName("한국인");
		return dataVo;
	}
	
	@GetMapping("test8_2")
	@ResponseBody	// 서버가 준 값 그대로 클라이언트에게 전달
	public List<DataVo> abc8_2() {
		List<DataVo> list = new ArrayList<DataVo>();
		for(int i=1;i<=5;i++) {
			DataVo dataVo = new DataVo();
			dataVo.setCode(i);
			dataVo.setName("한국인" + i);
			list.add(dataVo);
		}
		return list;
	}
}
