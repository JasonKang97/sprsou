package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter{
	@Autowired
	private JikwonInter inter;
	
	@Override
	public void dataPrint() {
		List<JikwonDto> list = inter.selectData();
		System.out.println("사번" + "\t" + "이름" + "\t" + "부서명" + "\t" + "입사년");
		for(JikwonDto j:list) {
			System.out.println(j.getJikwonno() + "\t" + j.getJikwonname() + "\t" + j.getBusername() + "\t" + j.getIbsayear());
		}
		
		System.out.println();
		System.out.println("부서별" + "\t" + "인원수");
		list = inter.selectBuserInwon();
		for(JikwonDto j:list) {
			System.out.println(j.getBusername() + "\t" + j.getJikwonsu());
		}
		
		System.out.println();
		System.out.println("부서별 최대 급여자");
		list = inter.selectHighPay();
		for(JikwonDto j:list) {
			System.out.println(j.getBusername() + " : " + j.getJikwonname() + " (" + j.getMaxpay() + ")");
		}
	}
}
