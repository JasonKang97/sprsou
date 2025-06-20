package pack.config;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	// SecurityFilterChain을 빈으로 생성
	// 스프링시큐리티는 시큐리티와 관련한 다양한 기능을 필터체인으로 제공함
	// 클라이언트요청 -> 필터 -> 필터 -> ... -> DispatcherServlet을 만남 (Controller를 수행)
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		String [] whiteList = {  // 인증 없이 접근 가능한 요청 나열
			"/", "/notice", "/shop", "/user/loginform", "/user/login_fail", "/user/expired"
		};
		
		httpSecurity
			.csrf(csrf -> csrf.disable())      // XSS 공격 방지용 csrf 처리 안함
			.authorizeHttpRequests(config ->   // 사용자 인증과 권한을 설정 
				config
					.requestMatchers("/error","/.well-known/**", "/favicon.ico").permitAll()
					.requestMatchers(whiteList).permitAll()
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.requestMatchers("/staff/**").hasAnyRole("ADMIN", "STAFF")
					.anyRequest().authenticated()   // 위의 요청을 제외한 나머지는 인증이 필요
			)
			.formLogin(config -> 
				config
					.loginPage("/user/required_loginform")
					.loginProcessingUrl("/user/login")
					.usernameParameter("userName")
					.passwordParameter("password")
					.successHandler(new AuthSuccessHandler())
					.failureForwardUrl("/user/login_fail")
					.permitAll()
			)
			.logout(config -> 
				config
					.logoutUrl("/user/logout")
					.logoutSuccessUrl("/")
					.permitAll()
			)
			.exceptionHandling(config ->   // 인증 처리 중 예외가 발생했을 때.
				config.accessDeniedPage("/user/denied")
			)
			.sessionManagement(config ->  // 세션 관리
				config
					.maximumSessions(1)   //최대 허용 세션 갯수
					.expiredUrl("/user/expired")  // 허용 세션 갯수 초과로 로그인 해제된 경우 이동 경로
			);
		
		return httpSecurity.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity httpSecurity,
			UserDetailsService userDetailsService,
			BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception{
		AuthenticationManagerBuilder managerBuilder = 
				httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
		managerBuilder
			.userDetailsService(userDetailsService)
			.passwordEncoder(bCryptPasswordEncoder);
		
		return managerBuilder.build();
	}
}
