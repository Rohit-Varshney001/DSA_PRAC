import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr [] = {3,1,55,6,3,52};
        System.out.println(maximumSubarraySum(arr,3));
        System.out.println(Arrays.toString(maximumSubarraySumIndex(arr,3)));
    }
    static public long maximumSubarraySum(int[] arr, int k) {
        int i = 0, j = 0;
        long max = 0;
        long sum = 0;

        while(j<arr.length){
            sum = sum + arr[j];
            if(j-i+1 < k){
                j++;
            }else{
                max = Math.max(max, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }

        }
        return max;

    }


    public static int[] maximumSubarraySumIndex(int [] arr, int k){
        int i = 0, j = 0;
        long max = 0;
        long sum = 0;
        int [] res = new int[2];

        while(j < arr.length){
            sum += arr[j];
            if(j-i+1 < k){
                j++;
            }else{
                if(sum>max){
                    res[0] = i;
                    res[1] = j;
                    max = sum;
                }
                sum = sum - arr[i];
                i++;
                j++;

            }
        }
        return res;
    }



}