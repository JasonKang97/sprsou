package pack.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Aspect
public class MyAspect {
	@Autowired
	private LoginClass loginClass;
	
	@Around("execution(* jikwonProcess*(..))")
	public Object aopProcess(ProceedingJoinPoint joinPoint) throws Throwable{
		// 로그인이므로 핵심 로직 수행 전 로그인 처리를 수행하도록 함(intercept)
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		
		// session을 처리해야 하기 때문에 pointcut 대상 메소드를 반복문을 이용한다.
		for(Object obj:joinPoint.getArgs()) {
			// getArgs(): pointcut 대상 메소드들의 인자를 읽어 request, response 객체를 얻음.
			if(obj instanceof HttpServletRequest) {
				request = (HttpServletRequest)obj;
			}
			if(obj instanceof HttpServletResponse) {
				response = (HttpServletResponse)obj;
			}
		}
		
		if(loginClass.loginCehck(request, response)) {
			// login을 하지 않았으므로 핵심 로직을 수행하지 못하도록 null을 반환
			return null;
		}
		
		Object object = joinPoint.proceed();
		
		return object;
	}
}
