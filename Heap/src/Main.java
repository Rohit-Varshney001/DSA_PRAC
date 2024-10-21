import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int [] arr = new int[]{2,42,1,34,54,212,32,45};
        int [] arr2 = new int[]{1,2,3,4,5};
        System.out.println("kth Largest---> "+kLargest(arr,3));
        System.out.println("kth Smallest---> "+kSmallest(arr,3));
        System.out.println("k closest---> "+ Arrays.toString( kClosestNumber(arr2,3,4)));
        System.out.println("k Frequent Numbers---> "+ Arrays.toString( kFrequentNumbers(new int[]{1,2,3,1,2,2,1}, 2)));
        System.out.println("k Closest Points To Origin ---> "+ Arrays.deepToString( kClosestPointsToOrigin(new int[][]{{1, 2}, {3, 1}, {2, 2}}, 2)));
        System.out.println("connect Ropes To Min Length---> "+ connectRopesToMinLength(new int[]{1,2,3,4,5}));
        System.out.println("Sum Between K1 and K2 Smallest---> "+ sumBetweenK1andK2Smallest(new int[]{1,2,3,4,5},2,4));
    }

    public static int kLargest(int[] arr, int k) {
//        maxHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int j : arr) {
            minHeap.add(j);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        if(minHeap.isEmpty()){
            return 0;
        }
        return minHeap.peek();
    }

    public static int kSmallestByNegativeTrick(int [] arr, int k){ //-ve Trick
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int i : arr){
            maxHeap.add(-1 * i);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return maxHeap.isEmpty() ? -1 : -1 * maxHeap.peek();
    }
    public static int kSmallest(int [] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y)->Integer.compare(y,x));
        for(int i : arr){
            maxHeap.add(i);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return maxHeap.isEmpty() ? -1 : maxHeap.peek();
    }
    public static int[] nearlySorted(int[] arr, int k) {
        int j = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i<arr.length; i++){
            minHeap.add(arr[i]);
            if(minHeap.size() > k){
                arr[j] = minHeap.poll();
                j++;
            }
        }
        while(!minHeap.isEmpty()){
            arr[j] = minHeap.poll();
            j++;
        }
        return arr;
    }
    public static int[] kClosestNumber(int [] arr, int num, int k){
        int [] res = new int[k];
        PriorityQueue<int[]> maxHeap= new PriorityQueue<>((x,y) -> Integer.compare(y[0],x[0]));
        for(int i = 0; i<arr.length; i++){
            maxHeap.add( new int[] {  Math.abs(arr[i] - num),arr[i] } );
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
            System.out.println(Arrays.deepToString(maxHeap.toArray()));

        }
        int j = 0;
        while (!maxHeap.isEmpty()){
            res [j] = maxHeap.poll()[1];
            j++;
        }
        return res;
    }

    public static int[] kFrequentNumbers(int [] arr, int val){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        System.out.println(map);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] res = new int[val];
        map.forEach((k, v) -> {
            minHeap.add(new int[]{k, v});

            if (minHeap.size() > val) {
                minHeap.poll();
            }
        });
        int i = 0;
        while (!minHeap.isEmpty()){
            res[i] = minHeap.poll()[0];
            i++;
        }

        return res;
    }
    static class Pair {
        int x;
        int y;
        long sqDist;

        Pair(int x, int y, long sqDist) {
            this.x = x;
            this.y = y;
            this.sqDist = sqDist;
        }
    }

    public static int[][] kClosestPointsToOrigin(int [][] arr, int k){
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b.sqDist, a.sqDist));
        int [][] res = new int[k][2];

        for (int[] point : arr) {
            int x = point[0];
            int y = point[1];
            long sqDist = (long) x * x + (long) y * y;
            maxHeap.add(new Pair(x, y, sqDist));

            // If heap size exceeds k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int i = 0;
        while(!maxHeap.isEmpty()){
            Pair pair = maxHeap.poll();
            res[i][0] = pair.x;
            res[i][1] = pair.y;
            i++;
        }
        return res;

    }

    public static int connectRopesToMinLength(int [] arr){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : arr){
            minHeap.add(i);
        }
        int totalCost = 0;
        while (minHeap.size()>1){
            int rp1 = minHeap.poll();
            int rp2 = minHeap.poll();
            int sum = rp1+rp2;
            totalCost += sum;
            minHeap.add(sum);
        }
        return totalCost;
    }
    public static int sumBetweenK1andK2Smallest(int[] arr, int k1, int k2) {
        // Finding k1-th and k2-th smallest elements
        int k1Smallest = kSmallest(arr, k1);
        int k2Smallest = kSmallest(arr, k2);

        // Calculate the sum of elements between k1-th and k2-th smallest
        int sum = 0;
        for (int num : arr) {
            if (num > k1Smallest && num < k2Smallest) {
                sum += num;
            }
        }
        return sum;
    }

}