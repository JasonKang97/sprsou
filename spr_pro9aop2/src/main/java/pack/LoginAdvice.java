package pack;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAdvice {
	@Around("execution(public void startProcess())")
	public Object myMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("id입력");
		Scanner scan = new Scanner(System.in);
		String id = scan.next();
		scan.close();
		
		if(id.equals("aa")) {
			System.out.println("아이디 불일치! 작업을 종료합니다.");
			return null;
		}
		
		Object object = joinPoint.proceed();	// around에 해당하는 메소드
		
		
		return object;
	}
}
