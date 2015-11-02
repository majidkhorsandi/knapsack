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

package org.videoplaza.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.videoplaza.knapsackImpl.AlternativeKnapsackSolver;
import org.videoplaza.knapsackImpl.Knapsack;
import org.videoplaza.utils.RandomCustomerGenerator;


import java.util.*;

/**
 * @version $Id:$
 */
public class BookingsTest {
	private static final Logger logger = LoggerFactory.getLogger(BookingsTest.class);

	@Parameters({"inventory", "numberOfCustomers", "maxImpressions", "maxRevenue"})
	@Test
	public final void testKnapSack(int inventory, int numberOfCustomers, int maxImpressions, int maxRevenue) {
		logger.info("==========  Testing knapsack algorithm used in the web service using another implementation of knapsack ==========");
		Customers testCustomers = new  Customers();
		List<Customer> customersList = new RandomCustomerGenerator(maxImpressions, maxRevenue).
				generateRandomCustomersList(numberOfCustomers);
		testCustomers.setCustomers(customersList);
		logger.info("List of random customers generated:");
		for (Customer customer: customersList){
			logger.info(customer.getName());
			logger.info(Integer.toString(customer.getImpressions()));
			logger.info(Integer.toString(customer.getRevenue()));
			logger.info("=========================");
		}
		AlternativeKnapsackSolver altKnapsack = new AlternativeKnapsackSolver(testCustomers, inventory);
		logger.info("Solving problem using algorithm under test");
		Bookings testBookings = new Bookings(testCustomers, inventory);
		logger.info("Solving problem using alternative algorithm");
		Knapsack alternativeSolution = altKnapsack.getOptimizedKnapsack();
		logger.info("=================================================");
		logger.info("total impressions calculated by algorithm under test: " + testBookings.getInventory());
		logger.info("total impressions calculated by alternative algorithm: " + altKnapsack.getSolutionSize());
		logger.info("=================================================");
		logger.info("total revenue by algorithm under test: " + testBookings.getRevenue());
		logger.info("total revenue by alternative algorithm: " + alternativeSolution.getValueOfSolution());
		Assert.assertEquals(testBookings.getRevenue(), alternativeSolution.getValueOfSolution());
		logger.info("List of sold campaigns by algorithm under test: ");
		for (SoldCampaign sold : testBookings.getSoldCampaigns()) {
			logger.info(sold.getCustomerName() + " : " + sold.getSold());
		}
		logger.info("=================================================");
		logger.info("List of sold campaigns by alternative algorithm: ");
		for (Map.Entry<Customer,Integer> campaign : alternativeSolution.getCampaigns().entrySet()){
			logger.info(campaign.getKey().getName() + " : " + campaign.getValue().toString());
		}
	}

}
