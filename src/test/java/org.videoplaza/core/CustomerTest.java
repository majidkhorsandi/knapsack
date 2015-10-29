

package org.videoplaza.core;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @version $Id:$
 */
public class CustomerTest  {
	private static final String CUSTOMER_NAME = "testCustomer";
	private static final int CUSTOMER_REVENUE = 100;
	private static final int CUSTOMER_IMPRESSION = 1000;

	private Customer customer;

@BeforeClass
public void createNewCustomer() {
	customer = new Customer(CUSTOMER_NAME, CUSTOMER_REVENUE, CUSTOMER_IMPRESSION);
}

@Test
public void testGetName() {
	Assert.assertEquals(customer.getName(), CUSTOMER_NAME);
}
}
