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
        System.out.println("Maximum value: " + knapsack01.knapsackRecDp(wt, val, DP, W, n));
        System.out.println("Maximum value: " + knapsack01.knapsackDP(wt, val, W, n));

//  ======= Subset Sum =======
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        System.out.println("Subset Sum : " + knapsack01.subsetSum(arr,sum));

//  ======== Equal Sum Partition ==========
        int[] arr2 = {1, 5, 11, 5};
        System.out.println("Equal Sum Partition: " + knapsack01.equalSumPartition(arr2));
//  ======= count subset with sum k ======
        int[] arr3 = {2,3,5,6,8,10};
        System.out.println("count Subset with sum k " + knapsack01.countSubsetWithSumK(arr3,10));


//  ======= Minimum subset sum diff========
        int [] arr4 = {1,3,7};
        System.out.println("Minimum subset sum diff : " + knapsack01.minSubsetSumDiff(arr4));
    }

}