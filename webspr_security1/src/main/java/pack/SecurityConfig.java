package pack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {	// 애플리케이션의 보안 구성을 설정(보안 설정, 인증, 폼로그인, ...)
	// SecurityFilterChain: 요청을 가로챈 후 인증/인가 부분을 체크한다. 이후 다음 작업으로 이어짐
	// HttpSecurity: 특정 http 요청에 대해 어떤 보안정책을 적용할지 구성
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth ->
				auth.requestMatchers("/login", "/kbs", "/mbc/**", "/error")		// 명시한 경로 이외에는 인증된 것들만 들어옴
					.permitAll()
					.anyRequest()
					.authenticated()
			)
			.formLogin(flog ->		
			// 로그인 처리시 사용자의 인증을 처리(기본적으로 POST /login 요청 처리함).
			// Security가 자동으로 로그인(/login), 로그인 실패(/login?error)를 생성한다. /login, /login?error와 같은 것을 endpoint라고 한다.
				flog.loginPage("/login")	// 사용자 정의 페이지를 지정
					.defaultSuccessUrl("/", true)	// 인증에 성공한 후 redirect될 기본 URL 지정
					.permitAll()
			)
			.logout(logout ->		// 로그아웃 기능을 설정(필요할 때만 설정 가능. 선택적) 
				logout.logoutUrl("/logout")		// 로그아웃 URL 설정(기본이 /logout으로 설정되어 있음)
					  .deleteCookies("JSESSIONID")
					  .permitAll()
			);
		
		return http.build();
	}
	
	// login.html에서 user, 제공된 password 대신 내가 입력한 id, password를 사용하기
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails = User.builder().username("myuser")
												.password(passwordEncoder().encode("123"))		// 비밀번호 암호화 처리
												.build();
		
		// InMemoryUserDetailsManager: 영구적 저장소 사용X. 재시작하면 정보 사라짐 - 테스트용
		return new InMemoryUserDetailsManager(userDetails);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();		// BCrypt hashing 알고리즘을 사용
	}
}
