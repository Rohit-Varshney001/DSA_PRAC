package Sorting.Sorting_Questions;

import java.util.Arrays;

public class minimum_difference_of_an_array {

//    ====== Naive Solution =====
/*    public static int minDiff(int[] arr){
        int res = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            for(int j= i+1; j<arr.length; j++){
                res = Math.min(res,Math.abs(arr[j] - arr[i]));
            }
        }
        return res;
    }
 */

//    ===== Better Solution =====
    public static int minDiff(int [] arr){
        int res = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for(int i = 1; i<arr.length; i++ ){
            res = Math.min(res,arr[i]-arr[i-1]);
        }
        return res;
    }

}
