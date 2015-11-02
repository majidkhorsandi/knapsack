package org.videoplaza.utils;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.videoplaza.core.Customer;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * Created by majid on 02/11/15.
 */
public class RandomCustomerGeneratorTest {

    private static final int MAX_IMPRESSIONS = 1000;
    private static final int MAX_REVENUE = 1000;
    private static final int CUSTOMER_LIST_SIZE = 3;
    private static final int TOO_BIG_LIST_SIZE = 1001;

    private Customer customer;
    private List<Customer> customerList;
    private RandomCustomerGenerator randomCustomerGenerator =
            new RandomCustomerGenerator(MAX_IMPRESSIONS, MAX_REVENUE);
    @Test
    public final void testGenerateSingleRandomCustomer() {

        customer = randomCustomerGenerator.generateSingleRandomCustomer();
        Assert.assertNotNull(customer);
        Assert.assertNotNull(customer.getName());
        Assert.assertNotNull(customer.getImpressions());
        Assert.assertNotNull(customer.getRevenue());
        Assert.assertTrue(customer.getRevenue() <= MAX_REVENUE);
        Assert.assertTrue(customer.getImpressions() <= MAX_IMPRESSIONS);
    }

    @Test(expectedExceptions = InvalidParameterException.class)
    public final void testGenerateTooSmallRandomCustomersList() {
        customerList = randomCustomerGenerator.generateRandomCustomersList(0);
    }

    @Test(expectedExceptions = InvalidParameterException.class)
    public final void testGenerateTooBigRandomCustomersList() {
        customerList = randomCustomerGenerator.generateRandomCustomersList(TOO_BIG_LIST_SIZE);
    }

    @Test
    public final void testGenerateRandomCustomerList() {
        customerList = randomCustomerGenerator.generateRandomCustomersList(CUSTOMER_LIST_SIZE);
        Assert.assertNotNull(customerList);
        Assert.assertEquals(customerList.size(), CUSTOMER_LIST_SIZE);
    }
}
