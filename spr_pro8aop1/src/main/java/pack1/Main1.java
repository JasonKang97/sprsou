package pack1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop1.xml");
		// AOP 적용 전
		//MessageInter inter = (MessageInter)context.getBean("messageImpl");
		//inter.sayHi();
		
		// AOP 적용 후
		MessageInter inter = (MessageInter)context.getBean("proxy");
		inter.sayHi();
	}

}
