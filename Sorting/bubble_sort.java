package Sorting;

import java.util.Arrays;

/**
 * bubble_sort
 */
public class bubble_sort {

    public void bubble_sort(int [] arr){
        for(int i = 0; i<arr.length-1; i++){
            Boolean swapped = false;    // Optimization -> in case if the array is already sorted then we don't have to check for whole array
            for(int j = 0; j<arr.length-i-1; j++){
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
        System.out.println("Via. Bubble Sort ::======>>  "+Arrays.toString(arr));
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}