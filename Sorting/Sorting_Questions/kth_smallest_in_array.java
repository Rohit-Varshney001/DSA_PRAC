package Sorting.Sorting_Questions;

public class kth_smallest_in_array {
    public static int partition(int[] arr, int l, int r)
    {
        int pivot = arr[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= pivot) {

                // Swapping arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }

        // Swapping arr[i] and arr[r]
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;

        return i;
    }
    public static int kth_smallest(int[] arr, int K){
        int l = 0, r = arr.length - 1;
        while(l <= r){
            int p = partition(arr,l,r);
            if(p == K-1){
                return arr[p];
            }else if(p> K-1){
                r = p-1;
            }else{
                r = p+1;
            }
        }
        return -1;

    }
}
