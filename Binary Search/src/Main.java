public class Main {
    public static void main(String[] args) {
        int arr[] = {2,3,4,6,7,9,11,22,34,54};
        int arr2[] = {55,45,36,23,20,11,9,8,6,4,3,2,1};
        System.out.println("Hello world!");
        System.out.println(BinarySearch(arr,2));
        System.out.println(BinarySearchUnknownSorted(arr2,3));
        System.out.println(FirstOccurrence(new int[]{10,10,10,18,20},10));
        System.out.println(LastOccurrence(new int[]{10,10,10,18,20},10));
        System.out.println(CountOfElement(new int[]{1,10,10,10,18,20},18));
        System.out.println(floor(new int[]{1,10,10,10,18,20},17));
        System.out.println(ceil(new int[]{1,10,10,10,18,20},17));

    }

    public static int BinarySearch(int [] arr, int val){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + ((end - start)/2);
            if(val < arr[mid]){
                end = mid-1;
            }else if(val>arr[mid]){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int BinarySearchUnknownSorted(int [] arr, int val){
        int start = 0;
        int end = arr.length-1;
        if(arr[start]>arr[end]){
            while(start <= end){
                int mid = start + ((end-start)/2);
                if(val > arr[mid]){
                    end = mid-1;
                }else if(val<arr[mid]){
                    start = mid +1;
                }else{
                    return mid;
                }
            }
        }else{
            return BinarySearch(arr,val);
        }
        return -1;
    }

    public static int FirstOccurrence(int [] arr, int val){
        int start = 0;
        int res = -1;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + ((end - start)/2);
            if(val < arr[mid]){
                end = mid-1;
            }else if(val>arr[mid]){
                start = mid+1;
            }else{
                res = mid;
                end = mid-1;
            }
        }
        return res;
    }

    public static int LastOccurrence(int [] arr, int val){
        int start = 0;
        int end = arr.length-1;
        int res = -1;
        while(start<=end){
            int mid = start + ((end-start)/2);
            if(val < arr[mid]){
                end = mid-1;
            }else if(val > arr[mid]){
                start = mid+1;
            }else{
                res = mid;
                start = mid+1;
            }
        }


        return res;
    }
    public static int CountOfElement(int [] arr, int value){
        int firstInd = FirstOccurrence(arr,value);
        int lastInd = LastOccurrence(arr,value);

        return firstInd == -1 ? -1: lastInd-firstInd+1;
    }


    public static int floor(int [] arr, int val){
        int start= 0, end = arr.length-1, res = -1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid] < val){
                res = arr[mid];
                start = mid+1;
            }else if(arr[mid]>val){
                end = mid-1;
            }else{
                return arr[mid];
            }
        }
        return res;
    }

    public static int ceil(int [] arr, int val){
        int start= 0, end = arr.length-1, res = -1;
        while(start<end){
            int mid = start + (end - start)/2;
            if(arr[mid] > val){
                end = mid-1;
                res = arr[mid];
            } else if (arr[mid] < val) {
                start = mid+1;
            }else {
                return arr[mid];
            }
        }
        return res;
    }



}