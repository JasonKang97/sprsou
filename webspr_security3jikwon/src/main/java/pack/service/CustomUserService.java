package pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pack.model.Jikwon;
import pack.model.JikwonRepository;

@Service
// UserDetailsService: 사용자 인증시 필요 정보 제공용 인터페이스. 사용자 정보를 DB 등에서 로드해 UserDetails 객체로 반환
public class CustomUserService implements UserDetailsService{
	
	@Autowired
	private JikwonRepository jikwonRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String sabun) throws UsernameNotFoundException {
		// 직원번호(sabun)로 사용자 정보를 조회한 후 UserDetails 객체를 생성하여 반환
		Integer jikwonNo = Integer.parseInt(sabun);
		Jikwon jikwon = jikwonRepository
						.findById(jikwonNo)
						.orElseThrow(() -> new UsernameNotFoundException("직원번호 오류:" + sabun));
		return User.builder()
				//.username(Integer.toString(jikwon.getJikwonno()))
				.username(jikwon.getJikwonname())		// 직원명을 username으로 사용
				.password(passwordEncoder.encode(jikwon.getJikwonname()))		// 직원명을 비밀번호로 사용
				.build();
	}
}
