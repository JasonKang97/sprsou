package pack.controller;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:init.xml");
		//GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:init.xml");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:pack/controller/init.xml");
		// singleton 확인
		MessageImpl messageImpl = (MessageImpl)context.getBean("messageImpl");
		messageImpl.sayHi();
		MessageImpl messageImpl2 = (MessageImpl)context.getBean("messageImpl");
		messageImpl2.sayHi();
		System.out.println(messageImpl + " " + messageImpl2);
		
		System.out.println();
		// 다형성
		MessageInter inter = (MessageInter)context.getBean("messageImpl");
		inter.sayHi();
		
		MessageInter inter2 = context.getBean("messageImpl", MessageImpl.class);
		inter2.sayHi();
		
		
		
		
		context.close();
	}
}
