package pack.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pack.model.Customer;
import pack.model.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/alldata")
	public List<Customer> allCustomers() {
		return customerService.printAllCustomers();
	}
	
	// 고객 자료 추가
	@PostMapping("/insert")
	public String insertCustomer(@RequestParam(name="name") String name, @RequestParam(name="age") int age, @RequestParam(name="gender") String gender) {
		return customerService.insertCustomer(name, age, gender);
	}

	// 고객 자료 수정
	@PostMapping("/updatedata")
	public String updateCustomer(@RequestParam(name="name") String name, @RequestParam(name="age") int age, @RequestParam(name="gender") String gender) {
		return customerService.updateCustomer(name, age, gender);
	}

	// 고객 자료 삭제
	@PostMapping("/delete")
	public String deleteCustomer(@RequestParam(name="name") String name) {
		return customerService.deleteCustomer(name);
	}
}
