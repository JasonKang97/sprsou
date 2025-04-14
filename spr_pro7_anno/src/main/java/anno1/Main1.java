package anno1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("anno1.xml");
		SenderProcess process = context.getBean("senderProcess", SenderProcess.class);
		process.displayData();
	}
}