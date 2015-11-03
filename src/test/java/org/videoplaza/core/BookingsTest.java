package org.videoplaza.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Optional;
import org.videoplaza.knapsackImpl.AlternativeKnapsackSolver;
import org.videoplaza.knapsackImpl.Knapsack;
import org.videoplaza.utils.JsonToCustomers;
import org.videoplaza.utils.RandomCustomerGenerator;


import java.util.*;

/**
 * @version $Id:$
 */
public class BookingsTest {
	private static final String PATH_TO_RESOURCES = "src/main/java/org/videoplaza/resources/";
	private static final Logger logger = LoggerFactory.getLogger(BookingsTest.class);

	@Parameters({"inventory", "numberOfCustomers", "maxImpressions", "maxRevenue", "customerFile"})
	@Test
	public final void testKnapSack(int inventory, int numberOfCustomers, int maxImpressions, int maxRevenue, @Optional() String customerFile) {
		logger.info("==========  Testing knapsack algorithm used in the web service using another implementation of knapsack ==========");
		Customers testCustomers = new  Customers();
		List<Customer> customersList;
		// check if we should read customers from file or generate them randomly.
		if (customerFile == null) {
			 logger.info("No json file found, generating random customers");
			 customersList = new RandomCustomerGenerator(maxImpressions, maxRevenue).
					generateRandomCustomersList(numberOfCustomers);
		}
		else {
			logger.info("generating customers from the json file: " + customerFile);
			customersList = new JsonToCustomers().convertJsonToCustomerList(PATH_TO_RESOURCES + customerFile + ".json");
		}

		testCustomers.setCustomers(customersList);
		logger.info("List customers generated:");
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
		logger.info("List of sold campaigns by algorithm under test: ");
		for (SoldCampaign sold : testBookings.getSoldCampaigns()) {
			logger.info(sold.getCustomerName() + " : " + sold.getSold());
		}
		logger.info("=================================================");
		logger.info("List of sold campaigns by alternative algorithm: ");
		for (Map.Entry<Customer,Integer> campaign : alternativeSolution.getCampaigns().entrySet()){
			logger.info(campaign.getKey().getName() + " : " + campaign.getValue().toString());
		}
		Assert.assertEquals(testBookings.getRevenue(), alternativeSolution.getValueOfSolution());

	}

}
