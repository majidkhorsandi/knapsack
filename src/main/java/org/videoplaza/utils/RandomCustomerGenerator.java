package org.videoplaza.utils;

import org.videoplaza.core.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by majid on 01/11/15.
 */
public class RandomCustomerGenerator {

    private static final int CUSTOMER_NAME_LENGTH = 5;

    private int maxImpression = 0;
    private int maxRevenue = 0;
    public RandomCustomerGenerator(int maxImpression, int maxRevenue) {
        this.maxImpression = maxImpression;
        this.maxRevenue = maxRevenue;
    }

    public Customer generateSingleRandomCustomer() {
        int randomImpression = new Random().nextInt(maxImpression + 1);
        int randomRevenue = new Random().nextInt(maxRevenue + 1);
        return  new Customer(new RandomString(CUSTOMER_NAME_LENGTH).nextString(), randomImpression, randomRevenue);

    }

    public List<Customer> generateMultipleRandomCustomers(int numberOfCustomers) {
        List<Customer> randomCustomers = new ArrayList<Customer>();
        for (int i=0; i<numberOfCustomers; i++) {
            randomCustomers.add(generateSingleRandomCustomer());
        }
        return randomCustomers;
    }
}
