import java.util.Arrays;

import Sorting.*;


public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,2,34,234,4,32,15,1};
//        int[] arr1 = {4,7,9,12,78};
//        int[] arr2 = {1,2,4,8,9};
//        new bubble_sort().bubble_sort(arr);
//        new selection_sort().selection_sort(arr);
//        new insertion_sort().insertion_sort(arr);
//        merge_sort.merge(arr1,arr2);
        merge_sort.mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));


    }
}