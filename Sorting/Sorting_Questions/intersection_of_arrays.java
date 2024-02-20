package Sorting.Sorting_Questions;

public class intersection_of_arrays {
//    ===== Naive Solution =====
//    public static void intersectionArr(int [] arr1, int [] arr2){
//        for(int i = 0; i<arr1.length; i++){
//            if(i>0 && arr1[i] == arr1[i-1]){
//                continue;
//            }
//            for(int j = 0; j<arr2.length; j++){
//                if(arr1[i] == arr2[j]){
//                    System.out.println(arr1[i]);
//                }
//            }
//        }
//    }

//    ===== Better Approach =====
    public static void intersectionArr(int [] arr1, int [] arr2){
        int i = 0; int j = 0;
        while(i < arr1.length && j<arr2.length){
//            if(i > 0 && arr1[i] == arr1[i-1]){   //to avoid repeated elements
//                i++;
//                continue;
//            }

            if(arr1[i] < arr2[j]){
                i++;
            }else if(arr1[i] > arr2[j]){
                j++;
            }else{
                System.out.println(arr1[i]);
                i++;
                j++;
            }
        }
    }


}
