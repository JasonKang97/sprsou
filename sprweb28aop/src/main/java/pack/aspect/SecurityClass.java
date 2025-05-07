package pack.aspect;

import org.springframework.stereotype.Component;

// 핵심 로직에 탈부착이 가능한 관심사항을 작성
// 여러 프로젝트에서 공통 기능을 별도 개발 후 필요한 프로젝트에 적용
@Component
public class SecurityClass {
	public void mySecurity() {
		System.out.println("핵심 메소드 수행 전 보안작업 실행");
	}
	
}
