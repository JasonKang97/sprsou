package pack2anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements LogicInter{	// 핵심 로직(비즈니스 영역)
	@Autowired
	private ArticleInter articleInter;
	
	@Override
	public void selectDataProcess1() {
		System.out.println("selectDataProcess1 수행");
		articleInter.selectAll();
	}
	
	@Override
	public void selectDataProcess2() {
		System.out.println("selectDataProcess2 처리");
		articleInter.selectAll();
	}
}
