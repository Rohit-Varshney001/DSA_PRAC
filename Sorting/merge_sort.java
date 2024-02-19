package Sorting;



public class merge_sort {

    public static void merge(int[] arr, int low, int mid, int high){
        int n1 = mid - low+1;
        int n2 = high - mid;
        int [] left = new int [n1];
        int [] right = new int [n2];
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


    }

    public static void mergeSort(int[] arr, int l, int r){
        if(r>l){
            int mid = l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }

    }


}
