package pack.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	@Autowired
	private SecurityClass class1;
	
	@Around("execution(public String processMsg()) or execution(public String businessMsg())")
	public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable {
		// 핵심 메소드 수행 전
		class1.mySecurity();
		
		Object object = joinPoint.proceed();	// 핵심 메소드
		
		// 핵심 메소드 수행 후
		
		return object;
	}
}
