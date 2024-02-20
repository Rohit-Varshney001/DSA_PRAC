package Sorting.Sorting_Questions;

import java.util.Arrays;

public class union_of_arrays {
//    ===== Naive Approach =====
//    public static void union(int [] arr1, int [] arr2){
//        int n = arr1.length+arr2.length;
//        int [] arr = new int[n];
//        for(int i = 0 ; i< arr1.length; i++){
//           arr[i] = arr1[i];
//        }
//        for(int i = 0 ; i< arr1.length; i++){
//           arr[arr1.length+i] = arr2[i];
//        }
//        Arrays.sort(arr);
//
//        for(int i = 0; i<arr.length; i++){
//            if(i>0 && arr[i] != arr[i-1]){
//                System.out.println(arr[i]);
//            }
//        }
//
//    }

//    ===== Better Approach =====
    public static void union(int [] arr1, int [] arr2){
        int i = 0; int j = 0;
        while(i < arr1.length && j<arr2.length){
            if(i > 0 && arr1[i] == arr1[i-1]){   //to avoid repeated elements
                i++;
                continue;
            }
            if(j > 0 && arr2[j] == arr2[j-1]){   //to avoid repeated elements
                j++;
                continue;
            }

            if(arr1[i] < arr2[j]){
                System.out.println(arr1[i]);
                i++;
            }else if(arr1[i] > arr2[j]){
                System.out.println(arr2[j]);
                j++;
            }else{
                System.out.println(arr1[i]);
                i++;
                j++;
            }
        }

        while(i<arr1.length){
            if(i > 0 && arr1[i] == arr1[i-1]){   //to avoid repeated elements
                i++;
                continue;
            }
            System.out.println(arr1[i]);
            i++;
        }
        while(j<arr2.length){
            if(j > 0 && arr2[j] == arr2[j-1]){   //to avoid repeated elements
                j++;
                continue;
            }
            System.out.println(arr2[j]);
            j++;
        }


    }


}
