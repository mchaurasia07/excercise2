package com.training.repository;

import com.training.Customer;

import java.util.List;

/**
 * Created by mchaurasia on 04-07-2016.
 */
public interface Repository {

    void createCustomer(Customer customer);
    Customer findByCustomerById(int id);
    List<Customer> findByFirstName(String firstName);
    List<Customer> findAll();
    int count();
    boolean delete(int customerId);

}
