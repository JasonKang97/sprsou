package pack.service;

import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	private Key key;
	
	@PostConstruct	// construct 이후 발생하는 메소드
	public void init() {
		key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	}
	
	public String createToken(String id) {	// JWT 토큰 생성
		return Jwts.builder()
				   .setSubject(id)		// 사용자 id로 sub claim 설정
				   .setIssuedAt(new Date())
				   .setExpiration(new Date(System.currentTimeMillis() + 3600000))
				   .signWith(key)
				   .compact();		// JWT 토큰 반환
	}
	
	// JWT에서 사용자 id 추출 메소드
	public String getUserIdFromToken(String token) {
		return Jwts.parserBuilder()
				   .setSigningKey(key)
				   .build()
				   .parseClaimsJws(token)
				   .getBody()
				   .getSubject();
	}
}
