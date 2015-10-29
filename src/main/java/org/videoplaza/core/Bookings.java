package org.videoplaza.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Bookings {

   private List<SoldCampaign> soldCampaigns;
   private int inventory;
   private int revenue;

   public Bookings(Customers customers, int inventory) {
      this.inventory = inventory;
      optimize(customers);
   }

   public void optimize(Customers customers) {
      unboundedKnapsack(customers); // Top down in the customers list
      inventory = calcTotalUsedInventory();
      revenue = calcTotalRevenue();
   }

   private void unboundedKnapsack(Customers customers) {
      int innerLoopSize = customers.getCustomers().size();
      int [] revenueSum = new int[inventory+1];
      int [] itemIndex = new int[inventory+1]; // Which customer do we sell for every impression
      int [] previousSumIndex = new int[inventory+1]; // To keep track of the previous stored sum

      // Initializing to indicate that we have not picked a match for this position
      Arrays.fill(previousSumIndex, -1);

      // All customers shall be returned so we need to initialize this collection
      HashMap<String, SoldCampaign> soldCampaignsCount = new HashMap<String, SoldCampaign>();
      for (Customer c : customers.getCustomers()) {
         soldCampaignsCount.put(c.getName(), new SoldCampaign(c));
      }

      int max = 0;
      for (int i=0; i<=inventory; i++) { // Loop through every available impression to look for fits.
         // For impression x loop through all customers, to find the next best fit
         for (int j=0; j<innerLoopSize; j++) {
            Customer customer = customers.getCustomers().get(j);
            if (customer.getImpressions() <= i) {
               // This rev + the previous sum of rev for this customer
               int value = customer.getRevenue() + revenueSum[i - customer.getImpressions()];
               if (value > max) {
                  revenueSum[i] = value;
                  itemIndex[i] = j;
                  previousSumIndex[i] = i - customer.getImpressions();
                  max = value;
               }
            }
         }
      }

      int i = inventory;
      while (i > 0) {
         if (previousSumIndex[i] == -1) {
            i--;
         } else {
            Customer c = customers.getCustomers().get(itemIndex[i]);
            if (soldCampaignsCount.containsKey(c.getName())) {
               // Get and increment on existing customer campaign.
               SoldCampaign scUpdate = soldCampaignsCount.get(c.getName());
               scUpdate.setImpressions(scUpdate.getImpressions()+c.getImpressions());
               scUpdate.setRevenue(scUpdate.getRevenue()+c.getRevenue());
               scUpdate.setSold(scUpdate.getSold()+1);
               soldCampaignsCount.put(scUpdate.getCustomerName(), scUpdate);
            }
            i = previousSumIndex[i];
         }
      }
      soldCampaigns = new ArrayList<SoldCampaign>(soldCampaignsCount.values());
   }

   private int calcTotalUsedInventory() {
      int usedInventory = 0;
      if (soldCampaigns != null) {
         for (SoldCampaign sc : soldCampaigns) {
            usedInventory += sc.getImpressions();
         }
      }
      return usedInventory;
   }

   private int calcTotalRevenue() {
      int totalRevenue = 0;
      if (soldCampaigns != null) {
         for (SoldCampaign sc : soldCampaigns) {
            totalRevenue += sc.getRevenue();
         }
      }
      return totalRevenue;
   }

   public void setInventory(int inventory) {
      this.inventory = inventory;
   }

   public void setRevenue(int revenue) {
      this.revenue = revenue;
   }

   public List<SoldCampaign> getSoldCampaigns() {
      return soldCampaigns;
   }

   public int getInventory() {
      return inventory;
   }

   public int getRevenue() {
      return revenue;
   }
}
