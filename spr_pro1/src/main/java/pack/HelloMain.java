package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
	public static void main(String[] args) {
		// 기존 방법 사용
		Message1 message1 = new Message1();
		message1.sayHello("신기해");
		System.out.println();
		MessageInter inter = message1;
		inter.sayHello("이기자");
		
		// Spring framework 사용
		System.out.println();
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		MessageInter messageInter = (MessageInter)context.getBean("msg");
		messageInter.sayHello("스프링");
	}
}
