package excercise2;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.mockito.*;

import com.training.Customer;
import com.training.repository.RepositoryImpl;


public class RepositoryImplTest {

	 List<Customer> list1 = new ArrayList<Customer>();
	 
	RepositoryImpl repoImp = new RepositoryImpl();
	
	@Before
	public void Sysout() {
		// TODO Auto-generated method stub
		System.out.println("Before test");
	}
	
	@After
	public void psysout() {
		// TODO Auto-generated method stub
		System.out.println("After test");
	}
	
	@Test
	public void testCreateCustomerFromRepo(){
	  Customer customer = new Customer(10,"Smita","Khedkar",26);
	 
	   repoImp.createCustomer(customer);
	
	   Assert.assertEquals(1, repoImp.count());
		
	}
	
	@Test
	public void testIsCustomerPresentInList(){
		Customer customer = new Customer(10,"Smita","Khedkar",26);
		 
		 repoImp.createCustomer(customer);
		
		Customer customer1 = repoImp.findByCustomerById(10);
	
		Assert.assertEquals("Test successfully executed",customer , customer1);
	}
	
	@Test
	public void testIsCustomerNotPresentInList(){
		Customer customer = new Customer(10,"Smita","Khedkar",26);
		 
		 repoImp.createCustomer(customer);
		
		Customer customer1 = repoImp.findByCustomerById(1);
		
		Assert.assertEquals("Null check", null, customer1);

	}
	
	@Test
	public void testIsCustomerDeletedFromList(){
		Customer customer = new Customer(10,"Smita","Khedkar",26);
		 
		 repoImp.createCustomer(customer);
		
		boolean result = repoImp.delete(10);
		
		Assert.assertEquals("Customer Deleted successfully", true, result);
	
	}
}
