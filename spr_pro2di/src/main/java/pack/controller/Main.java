package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pack.model.DataDao;
import pack.model.DataDaoImpl;

public interface Main {
	public static void main(String[] args) {
		// Spring X
		// DB 처리용
		DataDaoImpl daoImpl = new DataDaoImpl();
		DataDao dataDao = daoImpl;
		// 비즈니스 로직용
		SelectServiceImpl serviceImpl = new SelectServiceImpl(dataDao);
		SelectService service = serviceImpl;
		service.selectProcess();
		
		System.out.println();
		
		// Spring O
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		SelectService selectService = (SelectService)context.getBean("serviceImpl");
		selectService.selectProcess();
	}
}
