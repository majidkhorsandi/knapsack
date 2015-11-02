package org.videoplaza.knapsackImpl;

import org.videoplaza.core.Customer;
import org.videoplaza.core.Customers;
import java.util.Collections;
import java.util.HashMap;

public class Solver {

    private int[] subproblems;
    private Customer[] campaignsAdded;
    private Customers customers;
    private int valueSolution;
    private int backtrackOfSolution;

    /**
     * Constructor for the solver, initialize it with the campaigns to be used
     * to calculate the optimal solution and the maximum size of the knapsack
     *
     * @param customers
     * @param maxImpressions
     */
    public Solver(Customers customers, int maxImpressions) {
        this.customers = customers;
        this.subproblems = new int[maxImpressions + 1];
        this.campaignsAdded = new Customer[maxImpressions + 1];
        this.backtrackOfSolution = 0;
        this.valueSolution = 0;
    }

    /**
     * Generate the solution from the specified data.
     *
     */
    public void generateSolution() {
        for (int i = 1; i < subproblems.length; i++) {
            for (Customer element : customers.getCustomers()) {
                int itemWeight = element.getImpressions();
                int itemValue = element.getRevenue();
                if (itemWeight<=i
                        &&(itemValue+subproblems[i-itemWeight])>subproblems[i]) {
                        subproblems[i]= itemValue+subproblems[i-itemWeight];
                        campaignsAdded[i]=element;
                }
            }
        }
        valueSolution = subproblems[subproblems.length-1];
        backtrackOfSolution=subproblems.length-1;
    }

    /**
     * Generate the solution in a Knapsack object.
     *
     * @return knapsack with the solution value and capacity and the items of
     * the solution
     */
    public Knapsack obtainKnapsack() {
        Knapsack solution = new Knapsack(valueSolution, backtrackOfSolution);
        HashMap<Customer, Integer> backtrackSolution = new HashMap();

        Customer lastCustomer = campaignsAdded[backtrackOfSolution];
        int i = backtrackOfSolution;
        while (lastCustomer!=null&&i >= 0) {
            if (backtrackSolution.containsKey(lastCustomer)) {
                Integer counter = backtrackSolution.get(lastCustomer);
                backtrackSolution.put(lastCustomer, counter + 1);
            } else {
                backtrackSolution.put(lastCustomer, 1);
            }
            i -= lastCustomer.getImpressions();
            lastCustomer=campaignsAdded[i];
        }
        solution.setCampaigns(backtrackSolution);
        return solution;

    }

    public void applyPriorityCustomers() {
        Collections.sort(customers.getCustomers(), new CustomerComparator());
    }

    public void applyDominance() {
        int m = customers.getCustomers().size();
        for(int i=0;i<m-1;i++){
            Customer temp1 = customers.getCustomers().get(i);
            if (temp1.getRevenue() != 0) {
                for (int j = i + 1; j < m - 1; j++) {
                    Customer temp2 = customers.getCustomers().get(j);
                    if (((temp1.getImpressions()
                            * temp2.getRevenue())
                            / temp1.getRevenue())
                            < temp2.getImpressions()) {
                        customers.getCustomers().remove(j);
                        m--;
                    }

                }
            }
        }
    }

}
