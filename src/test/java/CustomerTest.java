import com.training.Customer;
import com.training.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by bantu.kumar on 07-08-2016.
 */
public class CustomerTest {
    private String expectedFirstName = "Bantu";
    private String expectedLastName = "Kumar";
    private int expectedID = 1000;
    private int expectedCount = 1;
    private int expectedAge = 28;

    Customer FCustomer;
    CustomerService FCustomerService;

    @Before public void Initialize() {
        FCustomer = new Customer(expectedID, expectedFirstName, expectedLastName, expectedAge);
        FCustomerService = new CustomerService();
        FCustomerService.createCustomer(FCustomer);
    }

    @Test public void testCustomerCreated() {
        Assert.assertEquals(expectedID, FCustomer.getId());
        Assert.assertEquals(expectedFirstName, FCustomer.getFirstName());
        Assert.assertEquals(expectedLastName, FCustomer.getLastName());
        Assert.assertEquals(expectedAge, FCustomer.getAge());
    }

    @Test public void testFindCustomerByID() {
        FCustomer = FCustomerService.findByCustomerById(expectedID);
        Assert.assertEquals(expectedFirstName, FCustomer.getFirstName());
        Assert.assertEquals(expectedLastName, FCustomer.getLastName());
        Assert.assertEquals(expectedAge, FCustomer.getAge());
    }

    @Test public void testFindAll() {
        List<Customer> customerList = FCustomerService.findAll();
        Assert.assertEquals(expectedCount, customerList.size());
    }

    @Test public void testFindByFirstName() {
        List<Customer> customers = FCustomerService.findByFirstName(expectedFirstName);
        Assert.assertEquals(expectedFirstName, customers.get(0).getFirstName());
    }

    @Test public void testCount() {
        Assert.assertEquals(expectedCount, FCustomerService.count());
    }

    @Test public void testDelete() {
        Assert.assertTrue(FCustomerService.delete(expectedID));
    }
}
