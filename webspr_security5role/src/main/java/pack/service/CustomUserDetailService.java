package pack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pack.entity.MyUser;

// 유저 정보를 가져외 처리
@Service
public class CustomUserDetailService implements UserDetailsService{
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username : " + username);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String role = "";
		if(username.equals("guest")) {
			role = "ROLE_USER";
		}else if(username.equals("batman")) {
			role = "ROLE_STAFF";
		}else if(username.equals("superman")) {
			role = "ROLE_ADMIN";
		}
		
		MyUser myUser = MyUser.builder()
							.id(1).userName(username)
							.password(encoder.encode("1234"))
							.role(role)
							.build();
		
		// 여러 개의 권한을 담는 컬렉션
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		// SimpleGrantedAuthority의 수퍼 인터페이스(구현체)가 GrantedAuthority
		authList.add(new SimpleGrantedAuthority(myUser.getRole()));
		
		UserDetails userDetails = new User(myUser.getUserName(), myUser.getPassword(), authList);
		
		// 반환된 UserDetails 객체를 이용해 계정과 비밀번호 유효성 검증, 권한 검증을 할 수 있다.
		return userDetails;
	}
}
