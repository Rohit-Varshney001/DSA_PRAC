package Sorting;

public class quick_sort {
//    Hoare's algorithm corrects inversions. Once there are no more inversions, the smaller index is returned as the pivot.
//    Lomuto's Algorithm either makes the first or the last element as the pivot. It brings each smaller element to the left one by one.

//    Hoare's algorithm does not bring the pivot to its correct place.
//    Lomuto's algorithm brings the pivot to its correct place it returns an index for pivot element at correct place


//    ===== Lomuto Partition =====      {10,80,30,90,40,50,70(p)}
    public static int lomutoPartition(int [] arr, int l, int h){
//        bubble_sort.swap(arr,p,h);// if pivot element needed to be taken as input
        int pivot = arr[h];
        int i = l-1;
        for(int j = l; j<=h-1; j++){
            if(pivot > arr[j]){
                i++;
                bubble_sort.swap(arr,i,j);
            }
        }
        bubble_sort.swap(arr,i+1,h);
        return (i+1);
    }

    public static int HoarePartition(int [] arr, int l ,int h){
        int pivot = arr[l];
        int i = l-1, j = h+1;

        while(true){
            do {
                i++;
            }while (arr[i] < pivot);
            do{
                j--;
            }while(arr[j] > pivot);
            if(i>=j){
                return j;
            }
            bubble_sort.swap(arr,i,j);
        }

    }

    public static void quickSortLomutoPart(int[] arr, int l, int h){
        if(l < h){
            int pivot = lomutoPartition(arr,l,h);
            quickSortLomutoPart(arr,l,pivot-1);
            quickSortLomutoPart(arr,pivot+1,h);

        }

    }
    public static void quickSortHoarePart(int[] arr, int l, int h){
        if(l < h){
            int pivot = lomutoPartition(arr,l,h);
            quickSortLomutoPart(arr,l,pivot);
            quickSortLomutoPart(arr,pivot+1,h);

        }

    }


}
