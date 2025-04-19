package Knapsack;

import java.util.ArrayList;

public class Knapsack0_1 {


    //    Knapsack 0/1 ---> Recursive
    public int knapsackRec(int[] wt, int[] val, int w, int n){
        if(n == 0 || w == 0){
            return 0;
        }
        if(wt[n-1] <= w){
            return Math.max(val[n-1] + knapsackRec(wt,val,w-wt[n-1], n-1), knapsackRec(wt,val,w, n-1));
        }else {   //if(wt[n-1] > w)
            return knapsackRec(wt,val,w,n-1);
        }
    }

//    Knapsack 0/1 ----> Memorization

    public int knapsackRecDp(int [] wt, int [] val, int [][] dp, int w, int n){
        if(n==0 || w==0){
            return 0;
        }
        if(dp[n][w] != -1){
            return dp[n][w];
        }
        if(wt[n-1] <= w){
            return dp[n][w] = Math.max(val[n-1] + knapsackRecDp(wt,val,dp,w-wt[n-1],n-1), knapsackRecDp(wt,val,dp,w,n-1));
        }else{
            return dp[n][w] = knapsackRecDp(wt,val,dp,w,n-1);
        }
    }

    public int knapsackDP(int [] wt, int [] val, int w, int n){
        int [][] dp = new int[n+1][w+1];

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<w+1; j++){
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];

    }

// Subset sum Problem....
//    We need to return true or false after checking if any subset has the sum equals k.

    public boolean subsetSum(int [] arr, int sum){
        int n = arr.length;
        boolean [][] dp = new boolean[arr.length+1][sum+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i<=arr.length; i++){
            for(int j = 1; j<=sum; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];;
                }

            }
        }
        return dp[arr.length][sum];
    }

    public boolean equalSumPartition(int [] arr){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
        }
        if(sum %2 != 0){
            return false;
        }
        sum = sum/2;
        boolean [][] dp = new boolean[arr.length+1][sum+1];
        for(int i = 0; i<=arr.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i<=arr.length; i++){
            for(int j = 1 ; j<=sum; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];

    }
//    count Subset With Sum K
    public int countSubsetWithSumK(int [] arr, int sum){
        int [][] dp = new int[arr.length+1][sum+1];
        for(int i = 0; i<=arr.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i<=arr.length; i++){
            for(int j = 1; j<= sum; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }

//    Minimum Subset Sum Difference
    public int minSubsetSumDiff(int [] arr){
        int range = 0;
        for (int k : arr) {
            range += k;
        }
        boolean [][] dp = new boolean [arr.length+1][range+1];

        for(int i = 0; i<=arr.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i<=arr.length; i++){
            for(int j = 1; j<= range; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;

        for(int j = 0; j<=range/2; j++){
            if(dp[arr.length][j]){
                min = Math.min(min, range-(2*j));

            }
        }

        return min;
    }
/*
====== Count the number of subset with a given difference =====
Approach------>
    s1 - s2 = diff
    s1 + s2 = Total sum of arr
    Add eq 1 & 2-----
    2s1 = diff+TotalSum
    s1 = diff+TotalSum / 2
  Now we only need to find the number of subArrays with the sum s1 and that's the answer
*/

    public int subSetWithGivenDiff(int [] arr , int diff){
        int s1 = 0;
        int totalSum = 0;
        for(int i = 0; i<arr.length; i++){
            totalSum += arr[i];
        }
        s1 = (diff+totalSum)/2;

//        int count = countSubsetWithSumK(arr,s1);
        int [][] dp = new int [arr.length+1][s1+1];

        for(int i = 0; i<=arr.length; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i<=arr.length; i++){
            for(int j = 1; j<=s1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][s1];


//        return count;
    }
 /*
====== Target Sum =====
We will be given an array we have to assign the '+' / '-' signs
such that the sum of the subarrays will be equal to  sum
Approach ----->
    arr = 1,1,2,3
        => +1, -1, -2, +3 => sum  = 1;
        => (+1 + +3) + (-1 + -2)
        => (1+3) - (1+2)
    it is reduced to =>  Count the number of subset with a given difference
*/

    public int targetSum(int [] arr, int sum){
        int s1 = 0, totalSum = 0;

        for(int i : arr){
            totalSum += i;
        }
        s1 = (totalSum + sum) / 2;

//        return countSubsetWithSumK(arr,s1);

        int [][]dp = new int[arr.length+1][s1+1];

        for(int i = 0; i<=arr.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i<= arr.length; i++){
            for(int j = 1; j<=s1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - arr[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][s1];

    }

}
