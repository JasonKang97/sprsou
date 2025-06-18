package pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// AuthenticationManager: 인증(Authentication)과 관련된 핵심적인 컴포넌트
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConf) throws Exception{
		return authConf.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
		//.csrf(csrf -> csrf.disable())		// 테스트에서 csrf를 사용하지 않으려면 사용
		.authorizeHttpRequests(auth -> 
			auth.requestMatchers("/auth/login", "/auth/logout", "/static/**")
				.permitAll()
				.anyRequest()
				.authenticated()
		)
		.formLogin(formLogin -> 	// 기본적으로 parameter는 username과 password 두가지만 받을 수 있다. 추가하기 위해서 별도의 클래스 필요
			formLogin.loginPage("/auth/login")
					 .loginProcessingUrl("/auth/login")
					 .usernameParameter("sabun")
					 .passwordParameter("irum")
					 .defaultSuccessUrl("/auth/success", true)
					 .permitAll()
		)
		.logout(logout -> 
			logout.logoutUrl("/auth/logout")
				  .logoutSuccessUrl("/auth/login")
				  .invalidateHttpSession(true)		// 세션 무효화
				  .clearAuthentication(true)		// 인증 정보 제거
				  .deleteCookies("JSESSIONID")		// 세션 쿠키 삭제
				  .permitAll()
		);
		
		
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
