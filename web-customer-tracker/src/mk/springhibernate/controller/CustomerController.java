package mk.springhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mk.springhibernate.entity.Customer;
import mk.springhibernate.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService ;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.getCustomers());
		return "list-customers";
	}
	
	@GetMapping("/showFormAdd")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer( @ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("customerId") int id, Model model) {
		
		Customer customer = customerService.getCustomer(id);
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id, Model model) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
}







