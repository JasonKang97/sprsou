package pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import pack.filter.JwtAuthenticationFilter;
import pack.util.JwtUtil;

@Configuration
@EnableWebSecurity	// 생략가능
public class SecurityConfig {
	private final JwtUtil jwtUtil;
	
	public SecurityConfig(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception{
		httpSecurity
		.csrf(csrf -> csrf.disable())		// 테스트에서 csrf를 사용하지 않으려면 사용
		.authorizeHttpRequests(auth -> 
			auth.requestMatchers("/", "/auth/login", "/auth/logout", "/static/**")
				.permitAll()
				.requestMatchers("/auth/success", "/auth/gugu", "/auth/guguresult")
				.authenticated()
		)
		// JWT 사용시 주의사항
		// 1) 세션관리 비활성화: 세션 대신 STATELESS 보안사용
		// 2) JWT 필터 추가: 요청마다 JWT 토큰을 확인하고 인증정보를 설정하기 위한 커스텀 필터 작성
		// 3) form 기반 인증 제거: JWT 인증에서는 보통 로그인 페이지를 사용하지 않고 REST api로 로그인 처리를 하므로 form 로그인 설정을 사용하지 않는다.
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		return httpSecurity.build();
	};
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
