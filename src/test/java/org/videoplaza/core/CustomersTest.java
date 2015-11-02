package org.videoplaza.core.core;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.videoplaza.core.Customer;

/**
 * Created by majid on 29/10/15.
 */
public class CustomersTest extends BaseTest{

    private Customer[] customers;

    @BeforeTest
    public void createNewCustomerList() {
        //JsonToCustomers customersFromFile = new JsonToCustomers();
       // customers = customersFromFile.convertJsonToCustomer();
    }

    @Test
    public final void testGetCustomers() {

    }
}
