package org.videoplaza.knapsackImpl;

import org.videoplaza.core.Customer;

import java.util.Comparator;

public class CustomerComparator implements Comparator<Customer> {

    @Override
    /**
     * Compares two customers based on their impression / revenue ration
     */
    public int compare(Customer o1, Customer o2) {

        double ratioCampaign1 = o1.getImpressions()
                / o1.getRevenue();
        double ratioCampaign2 = o2.getImpressions()
                / o2.getRevenue();

        if (ratioCampaign1 < ratioCampaign2) {
            return 1;
        } else if (ratioCampaign1 > ratioCampaign2) {
            return -1;
        } else {
            return 0;
        }
    }
}
