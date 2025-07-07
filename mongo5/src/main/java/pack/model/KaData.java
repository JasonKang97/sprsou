package pack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "katalkFiles")
public class KaData {
	@Id
	private String id;
	
	private String req;		// 질문
	private String res;		// 답변
}
