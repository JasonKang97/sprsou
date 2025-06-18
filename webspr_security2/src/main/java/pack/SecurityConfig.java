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

@Configuration	// 환경설정
@EnableWebSecurity	// web관련 보안 설정
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(auth -> 
			auth
			.requestMatchers("/admin").hasAnyRole("ADMIN")	// ADMIN 역할만 접근가능(예: 로그인 창)
			.requestMatchers("/user").hasAnyRole("USER")	// USER 역할만 접근가능(예: 로그인 창)
			.requestMatchers("/jamse").hasAnyRole("JAMSE")	// JAMSE 역할만 접근가능(예: 로그인 창)
			.requestMatchers("/common").permitAll()			// 예) http://localhost:8080/common
			.anyRequest().authenticated()
		)
		.formLogin(form -> 
			form
			.loginPage("/login")
			.defaultSuccessUrl("/default", true)
			.permitAll()
		)
		.logout(logout -> 
			logout
			.logoutUrl("/logout")
			.permitAll()
		);
		
		return httpSecurity.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails adminUser = User.builder()
									.username("admin")
									.password(passwordEncoder().encode("admin123"))
									.roles("ADMIN").build();
		UserDetails normalUser = User.builder()
									.username("user")
									.password(passwordEncoder().encode("user123"))
									.roles("USER").build();
		UserDetails jamesUser = User.builder()
									.username("james")
									.password(passwordEncoder().encode("james123"))
									.roles("JAMES").build();	// 내부적으로 ROLE_JAMES로 처리
		
		return new InMemoryUserDetailsManager(adminUser, normalUser, jamesUser);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}