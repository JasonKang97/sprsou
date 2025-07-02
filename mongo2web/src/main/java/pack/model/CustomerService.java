package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public void printAllCustomers() {
		customerRepository.findAll().forEach(customer -> {
			System.out.println(customer);
		});
	}
	public void insertCustomer(String name, int age, String gender) {	// 고객 추가(동일 이름 입력 방지)
		Customer existCustomer = customerRepository.findByName(name);
		
		if(existCustomer == null) {
			Customer newCustomer = new Customer();
			newCustomer.setName(name);
			newCustomer.setAge(age);
			newCustomer.setGender(gender);
			
			customerRepository.save(newCustomer);
		}else {
			System.out.println("이미 동일한 이름의 고객이 존재합니다.");
		}
	}
	
	public void updateCustomer(String name, int age, String gender) {	// 고객 수정
		Customer existCustomer = customerRepository.findByName(name);
		
		if(existCustomer != null) {		// age, gender 수정
			existCustomer.setAge(age);
			existCustomer.setGender(gender);
			
			customerRepository.save(existCustomer);
		}else {
			System.out.println("해당 고객의 정보가 존재하지 않습니다.");
		}
	}
	
	public void deleteCustomer(String name) {	// 고객 삭제
		Customer existCustomer = customerRepository.findByName(name);
		
		if(existCustomer != null) {
			customerRepository.delete(existCustomer);
		}else {
			System.out.println("해당 고객의 정보가 존재하지 않습니다.");
		}
	}
}
