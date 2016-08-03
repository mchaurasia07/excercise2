package com.training;

import com.training.repository.Repository;
import com.training.repository.RepositoryImpl;

import java.util.List;

/**
 * Created by mchaurasia on 04-07-2016.
 */
public class CustomerService {

    private Repository repository = new RepositoryImpl();

    public void createCustomer(Customer customer){
        repository.createCustomer(customer);
    }

    public Customer findByCustomerById(int id){
        return repository.findByCustomerById(id);
    }

    public List<Customer> findByFirstName(String firstName){
        return repository.findByFirstName(firstName);
    }

    public List<Customer> findAll(){
        return repository.findAll();
    }
    public int count(){
        return repository.count();
    }

    public boolean delete(int customerId){
        return repository.delete(customerId);
    }

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
    
    
}
