package Sorting.Sorting_Questions;

import Sorting.bubble_sort;

import java.util.Arrays;

public class sort_an_array_with_two_types_of_element {

//    ===== Positive on right and negative on left
    public static void segregate_positive_negative(int [] arr){
        int l = 0;
        int h = arr.length-1;

        int pivot = 0;
        int i = l-1;
        for(int j = l; j<=h-1; j++){
            if(pivot > arr[j]){
                i++;
                bubble_sort.swap(arr,i,j);
            }
        }
        bubble_sort.swap(arr,i+1,h);
        System.out.println(Arrays.toString(arr));
    }

}
