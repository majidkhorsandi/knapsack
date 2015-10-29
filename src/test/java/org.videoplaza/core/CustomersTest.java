package org.videoplaza.core;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.videoplaza.helper.JsonToCustomers;

/**
 * Created by majid on 29/10/15.
 */
public class CustomersTest {

    private Customer[] customers;

    @BeforeTest
    public void createNewCustomerList() {
        JsonToCustomers customersFromFile = new JsonToCustomers();
        customers = customersFromFile.convertJsonToCustomer();
    }

    @Test
    public final void testGetCustomers() {

    }
}
