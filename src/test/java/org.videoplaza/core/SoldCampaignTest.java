package org.videoplaza.core;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by majid on 29/10/15.
 */
public class SoldCampaignTest {

    private static final String CUSTOMER_NAME = "test customer";
    private static final String NEW_CUSTOMER_NAME = "new test customer";
    private static final int CUSTOMER_REVENUE = 100;
    private static final int CSTOMER_IMPRESSIONS = 1000;
    private static final int REVENUE = 50;
    private static final int INITIAL_SOLD = 0;
    private static final int SOLD = 20;
    private static final int NEW_REVENUE = 60;
    private static final int IMPRESSIONS = 1000;
    private static final int NEW_IMPRESSIONS = 800;

    private SoldCampaign soldCampaign;
    private Customer customer;

    @BeforeTest
    public final void createNewSoldCampaign() {
        customer = new Customer(CUSTOMER_NAME, CSTOMER_IMPRESSIONS, CUSTOMER_REVENUE);
        soldCampaign = new SoldCampaign(customer, IMPRESSIONS, REVENUE);
    }
    @Test
    public final void testGetRevenue() {
        Assert.assertEquals(soldCampaign.getRevenue(), REVENUE);
    }

    @Test
    public final void testSetRevenue() {
        soldCampaign.setRevenue(NEW_REVENUE);
        Assert.assertEquals(soldCampaign.getRevenue(), NEW_REVENUE);
    }

    @Test
    public final void testGetSold() {
        Assert.assertEquals(soldCampaign.getSold(), INITIAL_SOLD);
    }

    @Test
    public final void testSetSold() {
        soldCampaign.setSold(SOLD);
        Assert.assertEquals(soldCampaign.getSold(), SOLD);
    }

    @Test
    public final void testGetImpressions() {
        Assert.assertEquals(soldCampaign.getImpressions(), IMPRESSIONS);
    }

    @Test
    public final void testSetImpresisons() {
        soldCampaign.setImpressions(NEW_IMPRESSIONS);
        Assert.assertEquals(soldCampaign.getImpressions(), NEW_IMPRESSIONS);
    }

    @Test
    public final void testGetCustomerName() {
        Assert.assertEquals(soldCampaign.getCustomerName(), CUSTOMER_NAME);
    }

    @Test
    public final void testSetCustomerName() {
        soldCampaign.setCustomerName(NEW_CUSTOMER_NAME);
        Assert.assertEquals(soldCampaign.getCustomerName(), NEW_CUSTOMER_NAME);
    }

}
