package anno1;

import org.springframework.stereotype.Component;

@Component
public class Sender2 implements SenderInter{
	@Override
	public void show() {
		System.out.println("Sender2의 show");
	}
}