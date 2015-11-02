package org.videoplaza.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.videoplaza.core.Customer;
import org.videoplaza.utils.RandomCustomerGenerator;

import java.util.List;

/**
 * Created by majid on 29/10/15.
 */
public class CustomersTest {
	private static final int NUMBER_OF_RANDOM_CUSTOMERS = 5;
	private static final int MAX_IMPRESSIONS = 500;
	private static final int MAX_REVENUE = 50;
	private static final Logger logger = LoggerFactory.getLogger(BookingsTest.class);


	private List<Customer> testCustomersList;
	private Customers customers = new Customers();


    @BeforeTest
    public void createNewCustomerList() {
		testCustomersList = new RandomCustomerGenerator(MAX_IMPRESSIONS, MAX_REVENUE).
				generateRandomCustomersList(NUMBER_OF_RANDOM_CUSTOMERS);
		customers.setCustomers(testCustomersList);

    }

    @Test
    public final void testGetSetCustomers() {
		Assert.assertEquals(customers.getCustomers(),testCustomersList);
	}

}
