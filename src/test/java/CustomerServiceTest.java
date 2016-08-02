import com.training.Customer;
import com.training.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class CustomerServiceTest{
    CustomerService customerService;
    Customer customer;
    String firstName = "Clarice";
    int expectedCnt = 1;

    @Before
    public void setup(){
        customerService = new CustomerService();
        customer = new Customer(1,"Clarice","Globant",12);
        customerService.createCustom(customer);
    }

    @Test
    public void testAssert(){
        Assert.assertEquals("Method should test the first name",firstName, customer.getFirstName());
    }

    @Test
    public void testNotZero(){
         Assert.assertEquals("Customer count cannot be zero",Boolean.TRUE,customerService.getCustomerCount() > 0);
    }

    @Test
    public void testFindByFirstname(){
        List<Customer> customers = customerService.findCustomerByFirstName(firstName);
        Assert.assertEquals(firstName, customers.get(0).getFirstName());
    }

    @Test
    public void testFind(){
        Assert.assertEquals("Customer should not be null",customer,customerService.findByCustomerById(1));
    }

    @Test
    public void testFindAll(){
        List<Customer> customers = customerService.findAllCustomers();
        Assert.assertEquals("Test the findAllCustomers method",expectedCnt,customerService.findAllCustomers().size());
    }

    @Test
    public void testCount(){
        Assert.assertEquals("Should return the exact count of customers",expectedCnt,customerService.getCustomerCount());
    }

    @Test
    public void testDelete(){
        customer = new Customer();
        customerService.createCustom(customer);
        Assert.assertEquals("Method should return the customer name",Boolean.TRUE,customerService.delete(1));
    }
}