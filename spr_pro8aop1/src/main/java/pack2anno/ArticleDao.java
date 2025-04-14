package pack2anno;

import org.springframework.stereotype.Repository;

@Repository	// DB 처리용(영속성) 클래스에 대한 객체 생성 annotation
public class ArticleDao implements ArticleInter{	// 핵심 로직(모델 영역)
	@Override
	public void selectAll() {
		System.out.println("핵심 로직의 selectAll: 테이블 자료 읽기 성공");
		
	}
}
