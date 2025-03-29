package Knapsack;

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

    public int knapsackDP(int [] wt, int [] val,int [][] dp, int w, int n){
        if(n==0 || w==0){
            return 0;
        }
        if(dp[n][w] != -1){
            return dp[n][w];
        }
        if(wt[n-1] <= w){
            return dp[n][w] = Math.max(val[n-1] + knapsackDP(wt,val,dp,w-wt[n-1],n-1), knapsackDP(wt,val,dp,w,n-1));
        }else{
            return dp[n][w] = knapsackDP(wt,val,dp,w,n-1);
        }
    }

}
