package com.training;

/**
 * Created by mchaurasia on 05-07-2016.
 */
public class Test {

    public static void main(String args[]){
        CustomerService service = new CustomerService();
        Customer customer = new Customer(1, "John", "kumar", 24);
        service.createCustomer(customer);
        customer = new Customer(2, "Ram", "Singh", 25);
        service.createCustomer(customer);

        System.out.println("count : "+service.count());
        System.out.println("find all : " + service.findAll());
        System.out.println("By id : " + service.findByCustomerById(1));
        System.out.println("By id : " + service.findByCustomerById(2));
        System.out.println("by first name : " + service.findByFirstName("Ram"));
        customer = service.findByCustomerById(2);
        System.out.println("delete : " +service.delete(customer.getId()));

        System.out.println("count : "+service.count());
        System.out.println("find all : " + service.findAll());
        System.out.println("By id : " + service.findByCustomerById(1));
        System.out.println("By id : " + service.findByCustomerById(2));



    }
}
