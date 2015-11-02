package org.videoplaza.knapsackImpl;

import org.videoplaza.core.Customer;
import org.videoplaza.core.Customers;
import java.util.Map;

public class AlternativeKnapsackSolver {

    private int totalImpressions;
    private Customers customers;
    private Knapsack solution;

    public AlternativeKnapsackSolver(Customers customers, int maxImpressions) {
        this.totalImpressions = maxImpressions;
        this.customers = customers;
        Solver knapsackSolver = new Solver(getCustomers(), getTotalImpressions());
        knapsackSolver.applyPriorityCustomers();
        knapsackSolver.applyDominance();
        knapsackSolver.generateSolution();
        solution = knapsackSolver.obtainKnapsack();
    }

    /**
     * Returns maximum available impressions
     * @return number of total impressions
     */
    public int getTotalImpressions() {
        return totalImpressions;
    }

    /**
     * Returns list of customer campaigns
     * @return list of customers
     */
    public Customers getCustomers() {
        return customers;
    }

    public Knapsack getOptimizedKnapsack() {
        return this.solution;
    }

    /**
     * Returns size of the final solution, i.e number of impressions.
     * @return
     */
    public int getSolutionSize() {
        int solutionSize = 0;
        for (Map.Entry<Customer,Integer> campaign : solution.getCampaigns().entrySet()){
            solutionSize += campaign.getKey().getImpressions() * campaign.getValue();
        }
        return solutionSize;
    }

}
