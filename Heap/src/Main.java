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
}