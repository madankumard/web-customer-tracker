package mk.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mk.springhibernate.dao.CustomerDAO;
import mk.springhibernate.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers(){
		System.out.println("In Service Layer after interface");
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Customer customer = customerDAO.getCustomer(id);
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
		
	}
}
