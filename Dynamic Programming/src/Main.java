import Knapsack.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Knapsack0_1 knapsack01 = new Knapsack0_1();

        int[] wt = {2, 3, 4, 5};
        int[] val = {3, 4, 5, 6};
        int W = 7;
        int n = wt.length;
        System.out.println("Maximum value: " + knapsack01.knapsackRec(wt, val, W, n));

        int [][] DP = new int[n+1][W+1];
        for (int[] row : DP) {
            Arrays.fill(row, -1);
        }
        System.out.println("Maximum value: " + knapsack01.knapsackDP(wt, val, DP, W, n));



    }

}