import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.training.Customer;
import com.training.CustomerService;
import com.training.repository.Repository;

public class TestCustomerService {

	static Repository repositoryStub;
	static CustomerService service;
	
	@BeforeClass
	public static void setup() {
		repositoryStub = new RepositoryStub();
		service = new CustomerService();
		service.setRepository(repositoryStub);
		
		//loadDataForTest
		Customer customer = new Customer();
		customer.setFirstName("Dhanashree");
		customer.setLastName("Shirsat");
		customer.setAge(50);
		customer.setId(1);
		service.createCustomer(customer);

		customer = new Customer();
		customer.setFirstName("Dhanashree2");
		customer.setLastName("Shirsat2");
		customer.setAge(80);
		customer.setId(2);
		service.createCustomer(customer);
	}
	
	@Test
	public void testCreateCustomer() {
		System.out.println("testCreateCustomer");
		
		Customer customer = new Customer();
		customer.setFirstName("Dhanashree3");
		customer.setLastName("Shirsat3");
		customer.setAge(60);
		customer.setId(3);
		service.createCustomer(customer);
		
		Assert.assertEquals("Customer Created", 3, service.count());
	}
	
	@Test
	public void testFindByCustomerId() {
		System.out.println("testFindByCustomerId");
		Customer customer = service.findByCustomerById(1);
		Assert.assertEquals("Customer Exists", 1, customer.getId());
	}
	
	@Test
	public void testFindByFirstName() {
		System.out.println("testFindByFirstName");
		List<Customer> list = service.findByFirstName("Dhanashree");
		Assert.assertTrue("Customer Name - Dhanashree Exists",  list.size() > 0);
	}
	
	
	@Test
	public void testFindAll() {
		System.out.println("testFindAll");
		List<Customer> list = service.findAll();
		Assert.assertTrue("Customer Data Exists",  list.size() > 0);
	}
	
	@Test
	public void testCount() {
		System.out.println("testCount");
		int size = service.count();
		Assert.assertEquals("Total Customer count matching",  2 , size);
	}
	
	@Test
	public void testDelete() {
		System.out.println("testDelete");
		boolean deleted = service.delete(1);
		Assert.assertTrue("Customer with ID -1 deleted", deleted);
	}
	
	
}
