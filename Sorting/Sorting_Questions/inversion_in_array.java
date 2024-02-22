package Sorting.Sorting_Questions;

public class inversion_in_array {

//    ====== Naive Approach =====
//    public static int countInversion(int [] arr){
//        int res = 0;
//        for(int i = 0; i<arr.length; i++){
//            for(int j = i+1; j<arr.length; j++){
//                if(arr[i] > arr[j]){
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
//









//    ===== Better Approach =====

    public static int countInversion(int[] arr, int l, int r){
        int count = 0;
        if(r>l){
            int mid = l+(r-l)/2;
            count += countInversion(arr,l,mid);
            count += countInversion(arr,mid+1,r);
            count += merge(arr,l,mid,r);
        }
        return count;

    }

    public static int merge(int[] arr, int low, int mid, int high){
        int n1 = mid - low+1;
        int n2 = high - mid;
        int [] left = new int [n1];
        int [] right = new int [n2];
        int count = 0;
//        for(int i = 0; i<n2; i++){right[i] = arr[mid+1+i];}
//        for(int i = 0; i<n1; i++){left[i] = arr[low+i];}

        System.arraycopy(arr, low , left, 0, n1);
        System.arraycopy(arr, mid+1 , right, 0, n2);

        int i = 0, j = 0;
        int ind = low;
        while(i < n1 && j < n2){
            if (left[i] <= right[j]){
                arr[ind] = left[i];
                i++;
            }else{
                arr[ind] = right[j];
                j++;
                count += mid - (low + i) + 1; // Count inversions
            }
            ind++;
        }
        while(i<n1){
            arr[ind] = left[i];
            ind++;
            i++;
        }
        while(j<n2){
            arr[ind] = right[j];
            ind++;
            j++;
        }
        return count;


    }


}

