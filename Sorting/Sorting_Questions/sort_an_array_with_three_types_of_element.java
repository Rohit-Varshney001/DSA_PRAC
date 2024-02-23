package Sorting.Sorting_Questions;

import Sorting.bubble_sort;

import java.util.Arrays;

public class sort_an_array_with_three_types_of_element {
//======== Two Pointers ======
    static public void sort012Array(int [] arr){
        int l = 0, h = arr.length-1;
        int i= 0;
        while(i<arr.length && i<h){
            if(arr[i] == 0){
                bubble_sort.swap(arr,l,i);
                l++;
                i++;
            }else if(arr[i] == 2){
                bubble_sort.swap(arr,h,i);
                h--;
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


//    ========Dutch National Flag problem========
    public static void sort012(int a[]) {
        int lo = 0;
        int hi = a.length - 1;
        int mid = 0, temp = 0;
        // Iterate till all the elements
        // are sorted
        while (mid <= hi) {
            switch (a[mid]) {
                // If the element is 0
                case 0: {
                    bubble_sort.swap(a,lo,mid);
                    lo++;
                    mid++;
                    break;
                }
                // If the element is 1
                case 1:
                    mid++;
                    break;
                // If the element is 2
                case 2: {
                   bubble_sort.swap(a,mid,hi);
                    hi--;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
