package pack;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
	@MessageMapping("/chat.sendMessage")		// /app/chat.sendMessage로 전송한 메세지 처리. 처리된 메세지는 "/topic/public"으로 Broadcast한다. 
	@SendTo("/topic/public")
	public ChatMessage sendMessage(ChatMessage chatMessage) {
		return chatMessage;
		// 메세지는 자동으로 /topic/public 경로를 구독하고 있는 모든 사용자에게 전달
	}
	
	@MessageMapping("/chat.addUser")		// /app/chat.sendMessage로 전송한 메세지 처리. 처리된 메세지는 "/topic/public"으로 Broadcast한다. 
	@SendTo("/topic/public")
	public ChatMessage addUser(ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		// WebSocket 세션에 사용자의 이름을 저장한다. 세션은 클라이언트와 서버간의 연결을 추적
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		
		// 새로운 사용자 참여 메세지를 반환
		return chatMessage;
	}
}
