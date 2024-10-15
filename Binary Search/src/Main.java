import java.util.Arrays;

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
        System.out.println(noOfTimesArrayRotated(new int[]{10,20,30,40,50,1,2,3,4}));
        System.out.println(floor(new int[]{1,10,10,10,18,20},17));
        System.out.println(ceil(new int[]{1,10,10,10,18,20},17));
        System.out.println(findElementInSortedArray(new int[]{10,20,30,40,50,1,2,3,4},4));
        System.out.println(SearchingInInfiniteAray(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13},7));
        System.out.println(indexOfFirstOneInInfiniteSortedBinaryArray(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1}));
//Find minimum difference between any two elements (pair) in given array
        System.out.println(MinimumDifferenceElementInSortedArray(arr,20));
        System.out.println(peakElement(new int[]{1,2,1}));


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

    public static int noOfTimesArrayRotated(int []arr){
        int start = 0, end = arr.length-1;
        if(arr[start]<arr[end]) return 0;
        while(start <= end){
            int mid = start + (end-start)/2;
            int next = (mid+1) % arr.length;
            int prev = (mid+arr.length -1) % arr.length;
            if(arr[mid]<=arr[next] && arr[mid] <= arr[prev] ){
                return arr.length-mid;
            }else if(arr[end] <= arr[mid]){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return 0;
    }
    public static int indexOfMinimumElementInRotatedArr(int []arr){
        int start = 0, end = arr.length-1;
        if(arr[start]<arr[end]) return 0;
        while(start <= end){
            int mid = start + (end-start)/2;
            int next = (mid+1) % arr.length;
            int prev = (mid+arr.length -1) % arr.length;
            if(arr[mid]<=arr[next] && arr[mid] <= arr[prev] ){
                return mid;
            }else if(arr[end] <= arr[mid]){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return 0;
    }

    public static int findElementInSortedArray(int[] arr, int val) {
        int n = arr.length;
        int minIndex = indexOfMinimumElementInRotatedArr(arr);

        // Check if the element is at the minimum index
        if (arr[minIndex] == val) {
            return minIndex;
        }

        // Perform binary search on the left part (0 to minIndex - 1)
        int leftSearch = BinarySearch(Arrays.copyOfRange(arr, 0, minIndex), val);
        if (leftSearch != -1) {
            return leftSearch;
        }

        // Perform binary search on the right part (minIndex to n - 1)
        int rightSearch = BinarySearch(Arrays.copyOfRange(arr, minIndex, n), val);
        if (rightSearch != -1) {
            return minIndex + rightSearch;  // Adjust index for the second half
        }

        return -1;
    }

    public static int SearchingInInfiniteAray(int [] arr, int val){
        int low = 0, end = 1;

        while(val > arr[end]){
            low = end;
            end = end*2;
        }
        return low + BinarySearch(Arrays.copyOfRange(arr,low,end),val);
    }
    public static int indexOfFirstOneInInfiniteSortedBinaryArray(int [] arr){
        int start = 0, end = 1;
        while(1>arr[end]){
            start = end;
            end = end*2;
        }
        System.out.println("end"+end);
        System.out.println("start"+start);
        int res = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == 1){
                System.out.println("mid"+mid);
                res = mid;
                end = mid-1;
            }
            if(1<arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }
    public static int MinimumDifferenceElementInSortedArray(int [] arr, int key){
        int high = arr.length-1, low = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == key) return arr[mid];
            if(key<arr[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        System.out.println("floor = "+arr[high]);
        System.out.println("ceil = "+arr[low]);
        if(arr[high] - key > arr[low]-key){
            return arr[high];
        }
        return arr[low];
    }

    public static int peakElement(int [] arr){
        int start = 0, end = arr.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(mid>0 && mid<arr.length-1){
                if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                    return arr[mid];
                }else if(arr[mid-1] > arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else if(mid == 0){
                return Math.max(arr[mid], arr[mid + 1]);
            }else{
                return Math.max(arr[mid], arr[mid - 1]);
            }
        }


        return -1;
    }

}