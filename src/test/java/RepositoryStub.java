import java.util.ArrayList;
import java.util.List;

import com.training.Customer;
import com.training.repository.Repository;

/**
 * 
 * @author d.shirsat
 * Repository Stub created for Unit Testing the CustomerService class
 *
 */
public class RepositoryStub implements Repository {

	private List<Customer> list = new ArrayList<>();
	
	@Override
	public void createCustomer(Customer customer) {
		list.add(customer); 
	}

	@Override
	public Customer findByCustomerById(int id) {
		// TODO Auto-generated method stub
		for (Customer customer : list) {
			if(customer.getId() == id) {
				return customer;
			}
		}
		return null;
	}

	@Override
	public List<Customer> findByFirstName(String firstName) {
		List<Customer> newList = new ArrayList<>();
		for (Customer customer : list) {
			if(firstName != null && customer.getFirstName()!= null && customer.getFirstName().equals(firstName)) {
				newList.add(customer);
			}
		}
		return newList;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean delete(int customerId) {
		boolean deleted = false; 
		for (Customer customer : list) {
			if(customer.getId() == customerId) {
				list.remove(customer);
				deleted = true;
				break;
			}
		}
		return deleted;
	}

	
}
