package pack2anno;

import org.springframework.stereotype.Component;

@Component
public class AspectClass {
	public void abc() {
		System.out.println("관심사항: AOP 인터셉트");
	}
}
