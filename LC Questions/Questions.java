import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Questions {
    public static void main(String[] args) {
//====== 1.) Given an array of integers num and an integer target, return indices of the two numbers such they add up target.

        int [] arr = {23,12,123,123,14,26,33};
        int target = 246;
        int [] result = _2Sum(arr, target);
        System.out.println(Arrays.toString(result));

//  ===== 2.) Given an array of integers num, find the sub array with the largest sum and their sum.
        int [] arr2 = {-1,45,48,15,-15,98,-48};
        System.out.println("maxSum= "+largestSUmSubarray(arr2).max_sum + " sub-array = " + Arrays.toString(largestSUmSubarray(arr2).max_sum_subarray));

//  ===== 3.) Given an array of prices where prices[i] is the price of a given stock on an ith day. You want to maximize your profit  by choosing a single day to buy one stock and choosing a different day to sell that stock . Return the maximum profit you can achieve from this transaction. else return 0;
        System.out.println("Maximum profit: "+ BestDayToBuyAndSellStock(new int[]{7,1,5,3,6,4}));

//  ===== 4.) Given an array nums of n integers, return an array of all the unique quadruplets (nums[a], nums[b], nums[c],nums[c]) such that 0<=a,b,c,d<n &&&& a,b,d are distinct  &&&& nums[a] + nums[b] + nums[c] + nums[d] == target .
        System.out.println(fourSum(arr,297));

//        5.) Median of two sorted Arrays:
//                (i) Normal Approach
        System.out.println(findMedianSortedArraysNaive(new int[]{1,2,3}, new  int []{5,6,7,8}));
//                (ii) MergeSort Approach
        System.out.println(findMedianSortedArrays(new int[]{1,2,3}, new  int []{5,6,7,8}));

    }
    private static class ReqOutput {
        int max_sum;
        int[] max_sum_subarray;

        ReqOutput(int max_sum, int[] max_sum_subarray) {
            this.max_sum = max_sum;
            this.max_sum_subarray = max_sum_subarray;
        }
    }
    private static int[] _2Sum(int[] nums, int target){
        HashMap <Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int remVal = target - nums[i];
            if(map.containsKey(remVal)){
                return new int[] {map.get(remVal),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    private static ReqOutput largestSUmSubarray(int[] nums){

        int res = nums[0];  // Maximum sum found so far
        int prevMax = nums[0];  // Current max subarray sum
        int start = 0, end = 0, tempStart = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > prevMax + nums[i]) {
                prevMax = nums[i];
                tempStart = i;  // Update the temporary start of the subarray
            } else {
                prevMax += nums[i];
            }

            // Update the maximum sum found so far
            if (prevMax > res) {
                res = prevMax;
                start = tempStart;  // Update the start of the subarray
                end = i;  // Update the end of the subarray
            }
        }
        System.out.println("Subarray starts at index: " + start + ", ends at index: " + end);
        int[] subarray = new int[end - start + 1];
        System.arraycopy(nums, start, subarray, 0, end - start + 1);

        return new ReqOutput(res, subarray);
    }

    private static int BestDayToBuyAndSellStock(int [] nums){

        int min = nums[0];
        int maxprofit = 0;

        for (int num : nums) {
            min = Math.min(min, num);
            int profit = num - min;
            maxprofit = Math.max(profit, maxprofit);
        }
        return maxprofit;

    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
//   Sorting
        Arrays.sort(nums);
        int size = nums.length;
//   fixing first element
        for(int i = 0; i<size; i++){
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
//      fixing second element
            for(int j = i+1; j<size; j++){
//           checking for duplicates
                if(j != i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int k = j+1;
                int l = size-1;

                while(k<l){
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
//                      Checking Duplicates
                        while(k<l && nums[k] == nums[k-1]){
                            k++;
                        }
                        while(k<l && nums[l] == nums[l+1]){
                            l--;
                        }

                    }
                    else if(sum < target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return result;
    }

    public static double findMedianSortedArraysNaive(int[] nums1, int[] nums2) {
        int []arr = new int[nums1.length+nums2.length];
        int i = 0;
        for(; i<nums1.length; i++){
            arr[i] = nums1[i];
        }
        for (int k : nums2) {
            arr[i] = k;
            i++;
        }

        Arrays.sort(arr);
        double n;
        if(arr.length % 2 != 0){
            n = arr[arr.length/2];
        }else{
            n = (double)(arr[arr.length/2] + arr[arr.length/2 - 1])/2;
        }
        return n;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int [] finalArr = new int[nums1.length+nums2.length];

        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                finalArr[k++] = nums1[i++];
            }else{
                finalArr[k++] = nums2[j++];
            }
        }

        while(i<nums1.length){
            finalArr[k++] = nums1[i++];
        }
        while(j<nums2.length){
            finalArr[k++] = nums2[j++];
        }
        double n;
        if(finalArr.length % 2 != 0){
            n = finalArr[finalArr.length/2];
        }else{
            n = (double)(finalArr[finalArr.length/2] + finalArr[finalArr.length/2 - 1])/2;
        }
        return n;

    }

}

