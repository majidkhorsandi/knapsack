

package org.videoplaza.core;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.videoplaza.core.Customer;

/**
 * @version $Id:$
 */
public class CustomerTest  extends BaseTest{
	private static final String CUSTOMER_NAME = "testCustomer";
	private static final int CUSTOMER_REVENUE = 100;
	private static final int CUSTOMER_NEW_REVENUE = 200;
	private static final int CUSTOMER_IMPRESSION = 1000;
	private static final int CUSTOMER_NEW_IMPRESSION = 2000;

	private Customer customer;

	@BeforeTest
	public void createNewCustomer() {
		customer = new Customer(CUSTOMER_NAME, CUSTOMER_IMPRESSION, CUSTOMER_REVENUE);
	}

	@Test
	public void testGetName() {
		Assert.assertEquals(customer.getName(), CUSTOMER_NAME);
	}

	@Test
	public final void testSetImpressions() {
		customer.setImpressions(CUSTOMER_NEW_IMPRESSION);
		Assert.assertEquals(customer.getImpressions(), CUSTOMER_NEW_IMPRESSION);
	}

	@Test
	public final void testGetImpressions() {
		Assert.assertEquals(customer.getImpressions(), CUSTOMER_IMPRESSION);
	}

	@Test
	public final void testGetRevenue() {
		Assert.assertEquals(customer.getRevenue(), CUSTOMER_REVENUE);
	}

	@Test
	public final void testSetRevenue() {
		customer.setRevenue(CUSTOMER_NEW_REVENUE);
		Assert.assertEquals(customer.getRevenue(), CUSTOMER_NEW_REVENUE);
	}

}
