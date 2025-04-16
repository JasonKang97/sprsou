package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sprweb1Application {
	// 해당 클래스가 있는 패키지 또는 하위 패키지는 자동으로 스캔하지만 이외의 패키지는 스캔하지 않는다.
	public static void main(String[] args) {
		//SpringApplication.run(Sprweb1Application.class, args);
		SpringApplication.run(Sprweb1Application.class, args).getBean(Sprweb1Application.class).execute();
	}
	
	@Autowired
	private My my;
	
	private void execute() {
		System.out.println("독립적인 응용 프로그램 작성 가능");
		my.kbs();
	}
	

}
