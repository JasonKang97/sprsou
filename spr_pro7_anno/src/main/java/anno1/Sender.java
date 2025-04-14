package anno1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 스프링에서 Annotation은 특별한 의미, 기능을 수행하도록 하는 기술이다.

// @Component			// Sender sender = new Sender() <== 싱글톤의 의미임
// @Component("test")	// Sender test = new Sender()
@Component("sender")
@Scope("singleton")		// @Scope("prototype")
public class Sender implements SenderInter{
	public void show() {
		System.out.println("show 메소드 수행");
	}
}