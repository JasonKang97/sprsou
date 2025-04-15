package pack;

import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements LogicInter{
	public LogicImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void startProcess() {
		System.out.println("검증이 되었스므로 핵심 로직 수행");
	}
}
