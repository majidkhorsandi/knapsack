/*************************************************************************
 *
 * NORDNET CONFIDENTIAL
 *
 * [1996] - [2014] Nordnet Bank AB
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Nordnet Bank AB and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Nordnet Bank AB.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Nordnet Bank AB.
 *************************************************************************/

package org.videoplaza.helper;

import java.text.*;

/**
 * @version $Id:$
 */
public class knapsack {

	protected Item []  items = {
			new Item("A", 100,  10000, 0),
			new Item("B"  , 60,  5000, 0),
			new Item("C"   , 20,  2000, 0)
	};
	protected final int    n = items.length; // the number of items
	protected Item      sack = new Item("sack"   ,    0, 12000, 10000);
	protected Item      best = new Item("best"   ,    0,  0.0, 0.000);
	protected int  []  maxIt = new int [n];  // maximum number of items
	protected int  []    iIt = new int [n];  // current indexes of items
	protected int  [] bestAm = new int [n];  // best amounts

	public knapsack() {
		// initializing:
		for (int i = 0; i < n; i++) {
			maxIt [i] = Math.min(
					(int)(sack.getWeight() / items[i].getWeight()),
					(int)(sack.getVolume() / items[i].getVolume())
			);
		} // for (i)

		// calc the solution:
		calcWithRecursion(0);

		// Print out the solution:
		NumberFormat nf = NumberFormat.getInstance();
		System.out.println("Maximum value achievable is: " + best.getValue());
		System.out.print("This is achieved by carrying (one solution): ");
		for (int i = 0; i < n; i++) {
			System.out.print(bestAm[i] + " " + items[i].getName() + ", ");
		}
		System.out.println();
		System.out.println("The weight to carry is: " + nf.format(best.getWeight()) +
								   "   and the volume used is: " + nf.format(best.getVolume())
		);

	}

	// calculation the solution with recursion method
	// item : the number of item in the "items" array
	public void calcWithRecursion(int item) {
		for (int i = 0; i <= maxIt[item]; i++) {
			iIt[item] = i;
			if (item < n-1) {
				calcWithRecursion(item+1);
			} else {
				int    currVal = 0;   // current value
				double currWei = 0.0; // current weight
				double currVol = 0.0; // current Volume
				for (int j = 0; j < n; j++) {
					currVal += iIt[j] * items[j].getValue();
					currWei += iIt[j] * items[j].getWeight();
					currVol += iIt[j] * items[j].getVolume();
				}

				if (currVal > best.getValue()
						&&
						currWei <= sack.getWeight()
						&&
						currVol <= sack.getVolume()
						)
				{
					best.setValue (currVal);
					best.setWeight(currWei);
					best.setVolume(currVol);
					for (int j = 0; j < n; j++) bestAm[j] = iIt[j];
				} // if (...)
			} // else
		} // for (i)
	} // calcWithRecursion()

	// the main() function:
	public static void main(String[] args) {
		new knapsack();
	} // main()

}
