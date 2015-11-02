package org.videoplaza.utils;

import org.videoplaza.core.Customer;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by majid on 01/11/15.
 * Generates a single random customer or a list of random customers. Mainly used to generate test data.
 */
public class RandomCustomerGenerator {

    private static final int CUSTOMER_NAME_LENGTH = 5;
    private static final int MAX_SIZE_OF_CUSTOMER_LIST = 1000;

    private int maxImpression = 0;
    private int maxRevenue = 0;

    /**
     * Constructor method to initialize maximum impression and maximum revenue a customer campaign can have.
     * @param maxImpression
     * @param maxRevenue
     */
    public RandomCustomerGenerator(int maxImpression, int maxRevenue) {
        this.maxImpression = maxImpression;
        this.maxRevenue = maxRevenue;
    }

    /**
     * Generates a single customer by creating a random name, random impression and a random revenue for it
     * @return The generated random customer.
     */
    public Customer generateSingleRandomCustomer() {
        int randomImpression = new Random().nextInt(maxImpression + 1);
        int randomRevenue = new Random().nextInt(maxRevenue + 1);
        return  new Customer(new RandomStringGenerator(CUSTOMER_NAME_LENGTH).nextString(), randomImpression, randomRevenue);

    }

    /**
     * Generates a list of random customers.
     * @param numberOfCustomers
     * @return
     */
    public List<Customer> generateRandomCustomersList(int numberOfCustomers) {
        if (numberOfCustomers < 1 || numberOfCustomers > MAX_SIZE_OF_CUSTOMER_LIST) {
            throw new InvalidParameterException("List size must be between 1 and " + MAX_SIZE_OF_CUSTOMER_LIST);
        }
        List<Customer> randomCustomers = new ArrayList<Customer>();
        for (int i=0; i<numberOfCustomers; i++) {
            randomCustomers.add(generateSingleRandomCustomer());
        }
        return randomCustomers;
    }
}
