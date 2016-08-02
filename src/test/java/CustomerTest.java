import com.training.Customer;
import com.training.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by athite on 29-07-2016.
 */
public class CustomerTest {

    Customer customer;
    CustomerService customerService;

    private String expectedFirstName = "ABC";
    private String expectedLastName = "XYZ";
    private int expectedID = 1;
    private int expectedCount = 1;
    private int expectedAge = 34;

    @Before
    public void setup() {
        customer = new Customer(expectedID, expectedFirstName , expectedLastName, expectedAge);
        customerService = new CustomerService();
        customerService.createCust(customer);
    }

    public void assertCustomerInfo() {
        Assert.assertEquals(expectedFirstName, customer.getFirstName());
        Assert.assertEquals(expectedLastName, customer.getLastName());
        Assert.assertEquals(expectedAge, customer.getAge());
    }
    @Test
    public void testCustomerCreated() {
        Assert.assertEquals(expectedID, customer.getId());
        assertCustomerInfo();
    }

    @Test
    public void testFindCustomerByID() {
        customer = customerService.findByCustomerById(expectedID);
        assertCustomerInfo();
    }

    @Test
    public void testFindAll() {
        List<Customer> customerList = customerService.findAllCustomer();
        Assert.assertEquals(expectedCount, customerList.size());
    }

    @Test
    public void testFindByFirstName() {
        List<Customer> customers = customerService.findCustomerByFirstName(expectedFirstName);
        Assert.assertEquals(expectedFirstName, customers.get(0).getFirstName());
    }

    @Test
    public void testCount() {
        Assert.assertEquals(expectedCount, customerService.custCount());
    }

    @Test
    public void testDelete() {
        Assert.assertTrue(customerService.delete(expectedID));
    }

}
