package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> printAllCustomers() {
		return customerRepository.findAll();
	}
	
	// 고객 추가 (동일 이름 입력 방지)
	public String insertCustomer(String name, int age, String gender) {
		Customer existCustomer = customerRepository.findByName(name);
		if (existCustomer == null) {
			Customer newCustomer = new Customer();
			newCustomer.setName(name);
			newCustomer.setAge(age);
			newCustomer.setGender(gender);

			customerRepository.save(newCustomer);
			return "고객 추가 완료";
		} else {
			return "이미 동일한 이름의 고객이 존재합니다.";
		}
	}

	// 고객 수정
	public String updateCustomer(String name, int age, String gender) {
		Customer existCustomer = customerRepository.findByName(name);
		if (existCustomer != null) {
			// age, gender 수정
			existCustomer.setAge(age);
			existCustomer.setGender(gender);

			customerRepository.save(existCustomer);
			return "고객 정보 수정 완료";
		} else {
			return "해당 고객의 정보가 존재하지 않습니다.";
		}
	}

	// 고객 삭제
	public String deleteCustomer(String name) {
		Customer existCustomer = customerRepository.findByName(name);
		if (existCustomer != null) {
			customerRepository.delete(existCustomer);
			return "고객 삭제 완료";
		} else {
			return "해당 고객의 정보가 존재하지 않습니다.";
		}
	}
}
