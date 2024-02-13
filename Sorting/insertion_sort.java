package Sorting;

import java.util.Arrays;

// O(n2)-worst case
// O(n)-best case
// IN-place and stable
// used in practice for small arrays(like Tim sort, Intro sort)


// arr = [32,52,1,4,5];
// arr = [1,32,54,4,5]


public class insertion_sort {
    public void insertion_sort(int [] arr){
       for(int i = 1; i<arr.length; i++ ){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        System.out.println("Insertion Sort ::====>>   " + Arrays.toString(arr));

    }
}
