package Sorting;

import java.util.Arrays;

// Does less memory writes as compared to Quick Sort, Merge Sort, etc. but cycle sort is optimal in terms of memory writes.
// Not stable 
// In - place : n in-place sorting algorithm is a sorting algorithm that sorts the input array in place, without using any additional memory
// Basic Idea for Heap Sort
// O(n2)
// not stable

public class selection_sort {
    public void selection_sort(int [] arr){
        for(int i = 0; i<arr.length-1; i++){
            int min_index = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        System.out.println("Selection Sort ::====>>  " + Arrays.toString(arr));


    }
}
