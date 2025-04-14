package pack2anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfileAdvice {
	@Autowired
	private AspectClass aspectClass;
	
	@Around("execution(* *..*LogicInter*.*(..)) or execution(public void selectDataProcess1())")
	public Object kbs(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("메소드 수행 전, 하고싶은 작업");
		aspectClass.abc();
		Object object = joinPoint.proceed();	// 핵심 메소드
		
		System.out.println("메소드 수행 후, 마무리 할 작업");

		return object;
	}
}
