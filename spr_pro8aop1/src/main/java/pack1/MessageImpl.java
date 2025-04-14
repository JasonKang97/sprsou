package pack1;

public class MessageImpl implements MessageInter {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sayHi() {
		System.out.println("안녕하세요 " + name + "님. 비즈니스(핵심) 로직 수행 중");
		// 이 메소드는 처리 시간이 걸린다고 가정하고 지연 코드를 작성
		int t = 0;
		while(t<5) {
			try {
				Thread.sleep(1000);
				System.out.println("...");
				t++;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("sayHi 처리 완료");

	}
}
