package pack.controller;

import pack.model.MyInfo;
import pack.model.OurInfo;
import pack.other.OutFileInter;

public class MessageImpl implements MessageInter{
	private String name1, name2;	// 생성자 주입용
	private int year;
	private MyInfo myInfo;
	
	private String spec;	// setter 주입용
	private OurInfo ourInfo;
	private OutFileInter outFileInter;
	
	public MessageImpl(String name1, String name2, int year, MyInfo myInfo) {
		this.name1 = name1;
		this.name2 = name2;
		this.year = year;
		this.myInfo = myInfo;	// 주소 넘기기
	}
	
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public void setOurInfo(OurInfo ourInfo) {
		this.ourInfo = ourInfo;
	}
	
	public void setOutFileInter(OutFileInter outFileInter) {
		this.outFileInter = outFileInter;
	}
	
	@Override
	public void sayHi() {
		// 출력용 메소드
		String msg = name1 + " " + name2 + " ";
		msg += (year + 2000) + "년";
		msg += myInfo.myHobby();
		msg += "\n보유 기술은 " + spec;
		msg += "\n" + ourInfo.hello();
		System.out.println(msg);
		
		// 메세지를 파일로 출력하기
		outFileInter.outFileString(msg);
		
	}
}
