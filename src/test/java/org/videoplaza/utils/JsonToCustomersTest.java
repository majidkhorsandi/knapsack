package org.videoplaza.utils;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.videoplaza.core.Customer;
import java.util.List;

/**
 * Created by majid on 03/11/15.
 */
public class JsonToCustomersTest {

    private static final String PATH_TO_RESOURCES = "src/main/java/org/videoplaza/resources/";
    private static final String TEST_FILE = "testcustomers.json";
    private static final String BAD_JSON_TEST_FILE = "badjson.json";
    private static final String NOT_EXIST_FILE = "blabla.json";

    private JsonToCustomers jsonToCustomers;
    @Test
    public final void testConvertJsonToCustomerList() {
        jsonToCustomers = new JsonToCustomers();
        List<Customer> customers = jsonToCustomers.convertJsonToCustomerList(PATH_TO_RESOURCES + TEST_FILE);
        Assert.assertTrue(customers.get(0).getName().equals("CustomerA"));
        Assert.assertEquals(customers.get(0).getImpressions(), 3258035);
        Assert.assertEquals(customers.get(0).getRevenue(), 26);
    }


}
