package pack.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker	// STOMP 웹소켓 메시징을 활성화한다.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// "/topic"으로 시작하는 메세지는 메세지 브로커로 라우팅
		registry.enableSimpleBroker("/topic");
		
		// 사용자는 "/app"으로 시작하는 메세지를 해당 서버로 전송
		registry.setApplicationDestinationPrefixes("/app");
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// "/ws" 엔드포인트는 SockJs 옵션을 통해 웹소켓을 사용할 수 있도록 설정.
		//registry.addEndpoint("/ws").withSockJS();
		registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();	// 허용 도메인 설정 가능
		//registry.addEndpoint("/ws").setAllowedOriginPatterns("http://234.12.6.4", "https://www.daum.net").withSockJS();
	}
}
