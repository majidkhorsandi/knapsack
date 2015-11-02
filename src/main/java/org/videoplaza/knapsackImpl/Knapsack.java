package org.videoplaza.knapsackImpl;

import org.videoplaza.core.Customer;

import java.util.HashMap;

public class Knapsack {
    private HashMap<Customer,Integer> customers;
    private int valueOfSolution;
    private int sizeOfSolution;

    public Knapsack() {
        this.valueOfSolution = 0;
        this.sizeOfSolution = 0;
        this.customers= new HashMap();
    }

    public Knapsack(int valueOfSolution, int sizeOfSolution) {
        this.valueOfSolution = valueOfSolution;
        this.sizeOfSolution = sizeOfSolution;
        this.customers = new HashMap();
    }
    
    
    public int getValueOfSolution() {
        return valueOfSolution;
    }

    public void setValueOfSolution(int valueOfSolution) {
        this.valueOfSolution = valueOfSolution;
    }

    public int getSizeOfSolution() {
        return sizeOfSolution;
    }

    public void setSizeOfSolution(int sizeOfSolution) {
        this.sizeOfSolution = sizeOfSolution;
    }

    public HashMap<Customer, Integer> getCampaigns() {
        return customers;
    }

    public void setCampaigns(HashMap<Customer, Integer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Knapsack{" + "campaigns=" + customers
                + ", valueOfSolution=" + valueOfSolution 
                + ", sizeOfSolution=" + sizeOfSolution + '}';
    }
    
    
}
