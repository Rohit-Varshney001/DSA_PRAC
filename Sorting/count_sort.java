package Sorting;


import java.util.Arrays;

//======Naive Approach======
public class count_sort {

    public static void CountSort(int [] arr, int k){
        int [] count = new int [arr.length];
        for (int j : arr) {
            count[j]++;
        }

        int index = 0;
        for(int i =0; i<k; i++){
            for(int j = 0; j<count[i]; j++){
                arr[index] = i;
                index++;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

//    ===== Better Approach O(k+n)=====
     public static void CountSortBetterApp(int [] arr, int k){
         int[] count = new int[k];

         // Count occurrences of each element
         for (int i = 0; i < arr.length; i++) {
             count[arr[i]]++;
         }

         // Update count array to store cumulative counts
         for (int i = 1; i < k; i++) {
             count[i] += count[i - 1];
         }

         // Create a temporary array to store sorted elements
         int[] sortedArr = new int[arr.length];

         // Build sorted array
         for (int i = arr.length - 1; i >= 0; i--) {
             sortedArr[count[arr[i]] - 1] = arr[i];
             count[arr[i]]--;
         }
//         int[] arr1 = {1,2,3,2,1,3,2,1,4,2,1,2,2};
//         sorted[count[2]] ===> sorted[6--] = 2
//         sorted[count[2]] ===> sorted[5--] = 2

         // Copy sorted array back to original array
         System.arraycopy(sortedArr, 0, arr, 0, arr.length);
         System.out.println(Arrays.toString(arr));

    }



}
