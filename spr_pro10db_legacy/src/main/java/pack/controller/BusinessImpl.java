package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pack.model1.SangpumDto;
import pack.model1.SangpumInter;

@Service
public class BusinessImpl implements BusinessInter{
	@Autowired
	@Qualifier("sangpumImpl")
	private SangpumInter sangpumInter;
	
	@Override
	public void dataShow() {
		ArrayList<SangpumDto> list = sangpumInter.selectList();
		
		for(SangpumDto s:list) {
			System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan());
		}
	}
}
