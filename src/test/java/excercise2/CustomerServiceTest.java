package excercise2;

import org.junit.Before;
import com.training.Customer;
import com.training.CustomerService;
import com.training.repository.Repository;
import com.training.repository.RepositoryImpl;

import org.junit.Assert;

import org.junit.Test;


public class CustomerServiceTest {
	
	CustomerService customerService;
	Customer customer;
	Repository repository;
	
	@Before
	public void DoSetup()
	{
		customerService = new CustomerService();
		customer = new Customer(01, "Akshay", "Sharma", 25);
		customerService.createCustomerViaService(customer);
	}
	
	//Test createCustomer Method
	@Test
	public void testCreateCustomer()
	{
		Assert.assertEquals("Customer count should not be zero", Boolean.TRUE, customerService.getCustomerCount() > 0);
	}
	
	//Test findByCustomerById Method
	@Test
	public void testFindCustomerById()
	{
		Assert.assertEquals("Customer should not be null",customer, customerService.findByCustomerById(1));
	}
	
	//Test findCustomerByFirstName Method
	@Test
	public void testFindCustomerByFirstName()
	{
		Assert.assertEquals("Method should return customer by specified name", customer, (customerService.findCustomerByFirstName("Akshay")).get(0));
	}
	
	//Test findAll Method
	@Test
	public void testFindAllCustomers()
	{
		customer = new Customer(10, "Arun", "Sharma", 25);
		customerService.createCustomerViaService(customer);
		customer = new Customer(02, "Jay", "Varma", 25);
		customerService.createCustomerViaService(customer);
		Assert.assertEquals("Method should return all customers", customerService.getCustomerCount(), (customerService.findAllCustomers()).size());
	}
	
	//Test count Method
	@Test
	public void testGetCustomerCount()
	{
		Assert.assertEquals("Method should return exact count of customers added",  (customerService.findAllCustomers()).size(), customerService.getCustomerCount());
	}
	
	//Test 
	@Test
	public void testDeleteCustomer()
	{
		customer = new Customer(07, "Akshay", "Varma", 25);
		customerService.createCustomerViaService(customer);
		Assert.assertEquals("Method should return customer by specified name", Boolean.TRUE, customerService.delete(07));
	}
}
