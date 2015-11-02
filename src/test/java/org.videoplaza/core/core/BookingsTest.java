/*************************************************************************
 *
 * NORDNET CONFIDENTIAL
 *
 * [1996] - [2014] Nordnet Bank AB
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Nordnet Bank AB and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Nordnet Bank AB.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Nordnet Bank AB.
 *************************************************************************/

package org.videoplaza.core.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.videoplaza.core.Bookings;
import org.videoplaza.core.Customer;
import org.videoplaza.core.Customers;
import org.videoplaza.core.SoldCampaign;
import org.videoplaza.knapsackImpl.AlternativeKnapsackSolver;
import org.videoplaza.knapsackImpl.Knapsack;
import org.videoplaza.utils.JsonToCustomers;
import org.videoplaza.utils.RandomCustomerGenerator;
import org.videoplaza.utils.RandomString;

import java.math.BigInteger;
import java.security.SecureRandom;



import java.util.*;

/**
 * @version $Id:$
 */
public class BookingsTest {
	private static final int INVENTORY = 50000000;
	private static final int NUMBER_OF_RANDOM_CUSTOMERS = 5;
	private static final Logger logger = LoggerFactory.getLogger(BookingsTest.class);

	private static final String PATH_TO_RESOURCE = "src/main/java/org/videoplaza/resources/";

	@Test
	public final void testKnapSack() {
		Customers testCustomers = new  Customers();
		List<Customer> customersList = new RandomCustomerGenerator(6000, 6500).
				generateMultipleRandomCustomers(NUMBER_OF_RANDOM_CUSTOMERS);
		testCustomers.setCustomers(new JsonToCustomers().convertJsonToCustomerList(PATH_TO_RESOURCE + "customers2.json"));
		//testCustomers.setCustomers(customersList);
		for (Customer customer: customersList){
			logger.info(customer.getName());
			logger.info(Integer.toString(customer.getImpressions()));
			logger.info(Integer.toString(customer.getRevenue()));
			logger.info("=========================");
		}
		//AlternativeKnapsackSolver altKnapsack = new AlternativeKnapsackSolver(testCustomers, INVENTORY);
		//Bookings testBookings = new Bookings(testCustomers, INVENTORY);
		//Knapsack alternativeSolution = altKnapsack.getOptimizedKnapsack();

		//Assert.assertEquals(testBookings.getRevenue(), alternativeSolution.getValueOfSolution());
		//Assert.assertEquals(testBookings.getInventory(), altKnapsack.getSolutionSize());
		//for (Map.Entry<Customer,Integer> campaign : alternativeSolution.getCampaigns().entrySet()){
		//	logger.info(campaign.getKey().getName() + " : " + campaign.getValue().toString());
		//}
		//logger.info("===================================");
		//for (SoldCampaign sold : testBookings.getSoldCampaigns()) {
		//	logger.info(sold.getCustomerName() + " : " + sold.getSold());
		//}
	}

}
