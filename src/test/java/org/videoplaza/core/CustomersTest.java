package org.videoplaza.core;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.videoplaza.core.Customer;
import org.videoplaza.utils.RandomCustomerGenerator;

import java.util.List;

/**
 * Created by majid on 29/10/15.
 */
public class CustomersTest extends BaseTest{
	private static final int NUMBER_OF_RANDOM_CUSTOMERS = 5;

    private List<Customer> testCustomersList;
	private Customers customers = new Customers();


    @BeforeTest
    public void createNewCustomerList() {
		testCustomersList = new RandomCustomerGenerator(500, 50).
				generateMultipleRandomCustomers(NUMBER_OF_RANDOM_CUSTOMERS);
		customers.setCustomers(testCustomersList);

    }

    @Test
    public final void testGetSetCustomers() {
		Assert.assertEquals(customers.getCustomers(),testCustomersList);
	}

}
