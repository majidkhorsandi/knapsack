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

            /*
             Create solver with data
             */
            Solver knapsackSolver = new Solver(getCustomers(), getTotalImpressions());

            /*
             First impose ordering of items in order of their best ratio
             impression/value.
             Then apply dominance relation
             */
            knapsackSolver.applyPriorityCustomers();
            knapsackSolver.applyDominance();

            /*
             Generate the solution with dynamic programming and optimizations
             */
            knapsackSolver.generateSolution();

            /*
             Obtain the solution through backpointers of the elements
             */
            solution = knapsackSolver.obtainKnapsack();
    }

    /**
     * Getter of the target impressions we are looking the solution to
     *
     * @return number of total impressions for the month
     */
    public int getTotalImpressions() {
        return totalImpressions;
    }

    /**
     * Getter of the campaigns obtained from the file and need to be scheduled
     *
     * @return list of campaigns for this month
     */
    public Customers getCustomers() {
        return customers;
    }

    public Knapsack getOptimizedKnapsack() {
        return this.solution;
    }

    public int getSolutionSize() {
        int solutionSize = 0;
        for (Map.Entry<Customer,Integer> campaign : solution.getCampaigns().entrySet()){
            solutionSize += campaign.getKey().getImpressions() * campaign.getValue();
        }
        return solutionSize;
    }

}
