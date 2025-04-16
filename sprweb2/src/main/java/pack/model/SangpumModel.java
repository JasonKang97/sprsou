package pack.model;

import org.springframework.stereotype.Service;
import pack.controller.SangpumBean;

@Service
public class SangpumModel {
	public String computePrice(SangpumBean bean) {
		String data = "품명: " + bean.getSang() + ", 금액: " + bean.getSu()*bean.getDan();
		
		return data;
	}
}
