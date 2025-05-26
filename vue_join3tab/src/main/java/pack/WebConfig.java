package pack;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOriginPatterns("*")		// 모든 클라이언트 요청 허용
				.allowedMethods("GET", "POST", "PUT", "DELETE")		// 허용 메소드
				.allowCredentials(true);		// 쿠키 인증 요청 허용
	}
}


