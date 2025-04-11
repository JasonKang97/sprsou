package pack;

public class MyBusiness {
	private int nai;
	private String juso;
	private StringDatas datas;	// 클래스의 포함관계
	
	public MyBusiness() {
		// TODO Auto-generated constructor stub
	}
	
	public void setNai(int nai) {	// setter injection
		this.nai = nai;
	}
	
	public void setJuso(String juso) {
		this.juso = juso;
	}
	
	public void setDatas(StringDatas datas) {
		this.datas = datas;
	}
	
	public void displayData() {
		System.out.println("나이는 " + nai + "살, 주소는 " + juso);
		System.out.println("이름은 " + datas.processName());
		System.out.println("취미는 " + datas.processHobby());
	}
	
}
