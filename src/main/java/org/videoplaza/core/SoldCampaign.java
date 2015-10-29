package org.videoplaza.core;

public class SoldCampaign {
   private String customerName;
   private int sold = 0; // number of sold campaigns for this client
   private int impressions = 0;
   private int revenue = 0;

   public SoldCampaign(Customer customer) {
      this.customerName = customer.getName();
   }

   public SoldCampaign(Customer customer, int impressions, int revenue) {
      this.customerName = customer.getName();
      this.impressions = impressions;
      this.revenue = revenue;
   }

   public int getRevenue() {
      return revenue;
   }

   public void setRevenue(int revenue) {
      this.revenue = revenue;
   }

   public int getSold() {
      return sold;
   }

   public void setSold(int sold) {
      this.sold = sold;
   }

   public int getImpressions() {
      return impressions;
   }

   public void setImpressions(int impressions) {
      this.impressions = impressions;
   }

   public String getCustomerName() {
      return customerName;
   }

   public void setCustomerName(String name) {
      this.customerName = name;
   }
}
