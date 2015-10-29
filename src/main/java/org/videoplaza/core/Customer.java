package org.videoplaza.core;

public class Customer {
   private String name;
   private int impressions;
   private int revenue;

   public Customer() {}

   public Customer(String name, int impressions, int revenue) {
      this.name = name;
      this.impressions = impressions;
      this.revenue = revenue;
   }

   public String getName() {
      return name;
   }

   public int getImpressions() {
      return impressions;
   }

   public void setImpressions(int impressions) { this.impressions = impressions; }

   public int getRevenue() { return revenue; }

   public void setRevenue(int revenue) { this.revenue = revenue; }

}
