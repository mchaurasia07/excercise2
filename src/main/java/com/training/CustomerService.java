package com.training;

import com.training.repository.Repository;
import com.training.repository.RepositoryImpl;

import java.util.List;

/**
 * Created by mchaurasia on 04-07-2016.
 */
public class CustomerService {

    Repository repository = new RepositoryImpl();

    void createCustomer(Customer customer){
        repository.createCustomer(customer);
    }

    public Customer findByCustomerById(int id){
        return repository.findByCustomerById(id);
    }

    List<Customer> findByFirstName(String firstName){
        return repository.findByFirstName(firstName);
    }

    List<Customer> findAll(){
        return repository.findAll();
    }
    int count(){
        return repository.count();
    }

    public boolean delete(int customerId){
        return repository.delete(customerId);
    }

    public void createCust(Customer customer){
        this.createCustomer(customer);
    }

    public List<Customer> findCustomerByFirstName(String firstName){
        return this.findByFirstName(firstName);
    }

    public List<Customer> findAllCustomer(){
        return this.findAll();
    }

    public int custCount(){
        return this.count();
    }
}
