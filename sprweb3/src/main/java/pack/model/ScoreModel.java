package pack.model;

import org.springframework.stereotype.Service;

@Service
public class ScoreModel {
	public String score(ScoreBean bean) {
		String data = bean.getName() + "님의 총점은 " + (bean.getJava()+bean.getPython()) + "점, 평균은 "
					+ (bean.getJava()+bean.getPython())/2 + "점입니다." ;
		return data;
	}
}
