package com.training.repository;

import com.training.Customer;

import java.util.ArrayList;
import java.util.List;
import org.mockito.*;

/**
 * Created by mchaurasia on 04-07-2016.
 */
public class RepositoryImpl implements Repository {

    @Spy
    List<Customer> list = new ArrayList<Customer>();

    public void createCustomer(Customer customer) {
        list.add(customer);
    }

    public Customer findByCustomerById(int id) {
        Customer customer = null;
        for(Customer cust : list){
            if(id == cust.getId()) {
                customer = cust;
                break;
            }
        }
        return customer;
    }


    public List<Customer> findAll() {
        return list;
    }

    public int count() {
        return list.size();
    }

    public List<Customer> findByFirstName(String name) {
        List<Customer> customers = new ArrayList<Customer>();
        for(Customer cust : list){
            if(name.equals(cust.getFirstName())) {
                customers.add(cust);

            }
        }
        return customers;
    }

    public boolean delete(int customerId){
        boolean deleted = false;
        List<Customer> customers = new ArrayList<Customer>();
        for(int i=0; i<list.size(); i++){
            Customer customer = list.get(i);
            if(customerId == customer.getId()) {
                list.remove(i);
                deleted=true;
                break;

            }
        }
        return deleted;

    }
}
