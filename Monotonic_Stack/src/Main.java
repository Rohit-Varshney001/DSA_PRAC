import java.util.Arrays;
import java.util.Stack;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        int [] arr = {45,36,85,12,23};
        int [] arr = {100,80,60,70,60,75,85};
//        System.out.println(MonotonicStack(arr));
//        System.out.println(Arrays.toString(nxt_largest_element(arr)));
//        System.out.println(Arrays.toString(nxt_largest_element_right_stack(arr)));
//        System.out.println(Arrays.toString(nxt_largest_element_left_stack(arr)));
//        System.out.println(Arrays.toString(nearest_smaller_element_left_stack(arr)));
//        System.out.println(Arrays.toString(nearest_smaller_element_right_stack(arr)));
//        System.out.println(Arrays.toString(stockSpan(arr)));
//        System.out.println(Arrays.toString(stockSpan_ArrayStack(arr)));
//        System.out.println(MaxAreaHistogram(new int[] {9,0}));
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maxAreaRectangleInBinaryMatrix(matrix));
        System.out.println(trappingRainWater(new int[] {3,0,0,2,0,4}));
    }

    public static Stack<Integer> MonotonicStack(int [] arr){
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            while(!stack.isEmpty() && stack.peek() < i){
                stack.pop();
            }
            stack.push(i);
        }
        return stack;
    }

    public static int[]  nxt_largest_element(int [] arr){
        int [] res = new int[arr.length];
        for(int i = 0; i<arr.length;i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] > arr[i]){
                    res[i] = arr[j];
                    break;
                }
                res[i] = -1;
            }
        }
        res[arr.length-1] = -1;
    return res;
    }

    public static int[] nxt_largest_element_right_stack(int [] arr){
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length-1; i>=0; i--){
            if(stack.isEmpty()){
                res[i] = -1;
            }else if (stack.peek() > arr[i]){
                res[i] = stack.peek();
            }else{
                while (!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = -1;
                }else{
                    res[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }

       return res;
    }

    public static int[] nxt_largest_element_left_stack(int [] arr){
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<arr.length; i++){
            if(stack.isEmpty()){
                res[i] = -1;
            }else if (stack.peek() > arr[i]){
                res[i] = stack.peek();
            }else{
                while (!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = -1;
                }else{
                    res[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }

        return res;
    }


    public static int[] nearest_smaller_element_left_stack(int [] arr){
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<arr.length; i++){
            if(stack.isEmpty()){
                res[i] = -1;
            }else if (stack.peek() < arr[i]){
                res[i] = stack.peek();
            }else{
                while (!stack.isEmpty() && stack.peek()>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = -1;
                }else{
                    res[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }

        return res;
    }

    public static int[] nearest_smaller_element_right_stack(int [] arr){
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length-1; i>=0; i--){
            if(stack.isEmpty()){
                res[i] = -1;
            }else if (stack.peek() < arr[i]){
                res[i] = stack.peek();
            }else{
                while (!stack.isEmpty() && stack.peek()>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = -1;
                }else{
                    res[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }

        return res;
    }



     public static int [] stockSpan(int [] arr){
            int [] res = new int[arr.length];
            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i<arr.length; i++){
                if(stack.isEmpty()){
                    res[i] = 1;
                } else if (stack.peek() > arr[i]) {
                    res[i] = arr[stack.peek()];
                }else{
                    while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                        stack.pop();
                    }
                    if (stack.isEmpty()){
                        res[i] = 1;
                    }else{
                        res[i] = i-stack.peek();
                    }
                    res[i] = i - stack.peek();
                }

                stack.push(i);
            }
            return res;
     }

     public static int [] stockSpan_ArrayStack(int [] arr){ //NGL
            int[] res = new int[arr.length];
            Stack<int[]> stack = new Stack<>();

            for(int i = 0 ; i<arr.length; i++){
                if(stack.isEmpty()){
                    res[i] = 1;
                }else if(stack.peek()[1] > arr[i]){
                    res[i] = i - stack.peek()[0];
                }else{
                    while(!stack.isEmpty() && stack.peek()[1] <= arr[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        res[i] = 1;
                    }else{
                        res[i] = i-stack.peek()[0];
                    }
                }
                stack.push(new int[]{i,arr[i]});
            }


            return res;
     }

    public static int MaxAreaHistogram(int [] arr){
            int [] NSR = new int[arr.length];
            int [] NSL = new int[arr.length];
            int [] width = new int[arr.length];
            int [] area = new int[arr.length];
            Stack<int[]> stack1 = new Stack<>();
    //        =======NSR=============
            for(int i = arr.length-1; i>=0; i--){
                if (stack1.isEmpty()){
                    NSR[i] = arr.length;
                }else if (stack1.peek()[1] < arr[i]){
                    NSR[i] = stack1.peek()[0];
                }else{
                    while (!stack1.isEmpty() && stack1.peek()[1] >= arr[i]){
                        stack1.pop();
                    }
                    if (stack1.isEmpty()){
                        NSR[i] = arr.length ;
                    }else{
                        NSR[i] = stack1.peek()[0];
                    }
                }
                stack1.push(new int[]{i,arr[i]});
            }
            System.out.println(Arrays.toString(NSR));
            while(!stack1.isEmpty()){
                stack1.pop();
            }
    //==============NSL=========
            for(int i = 0; i<arr.length; i++){
                if(stack1.isEmpty()){
                    NSL[i] = -1;
                }else if(stack1.peek()[1] < arr[i]){
                    NSL[i] = stack1.peek()[0];
                }else{
                    while (!stack1.isEmpty() && stack1.peek()[1] >= arr[i]  ){
                        stack1.pop();
                    }
                    if(stack1.isEmpty()){
                        NSL[i] = -1;
                    }else{
                        NSL[i] = stack1.peek()[0];
                    }
                }
            stack1.push(new int[]{i,arr[i]});
            }
            System.out.println(Arrays.toString(NSL));
            int max = 0;
            for(int i= 0; i<arr.length; i++){
                width[i] = NSR[i] - NSL[i] -1;
                area[i] = width[i] * arr[i];
                max = Math.max(area[i],max);
            }
            return max;
        }


    public static int maxAreaRectangleInBinaryMatrix(char[][] matrix) {
        int max = 0;
        int []arr = new int[matrix[0].length];

//        First we are converting 2-d array into 1-D array like passing each row at once for MaxAreaHistogram then using mxa between them as result
        for(int j = 0; j<matrix[0].length; j++){
            arr[j] = matrix[0][j] - '0';
        }
        max = Math.max(max, MaxAreaHistogram(arr));

        for(int i = 1; i<matrix.length; i++){
            for (int j  = 0; j<matrix[i].length; j++){
                if(matrix[i][j] == '0'){
                    arr[j] = 0;
                }else{
                    arr[j] = arr[j] + matrix[i][j] - '0';
                }
            }
            max = Math.max(max, MaxAreaHistogram(arr));
        }



        return max;
    }


    public static int trappingRainWater(int [] arr){
        int [] msl = new int[arr.length];
        int [] msr = new int[arr.length];
//        First we are finding max value in the array at left and right.

        for(int i = 0; i<arr.length; i++){
            if(i == 0){
                msl[i] = arr[i];
            }else{
                msl[i] = Math.max(msl[i-1],arr[i]);
            }
        }
        for(int i = arr.length-1; i>=0; i--){
            if(i == arr.length-1){
                msr[i] = arr[i];
            }else{
                msr[i] = Math.max(msr[i+1], arr[i]);
            }
        }
        System.out.println(Arrays.toString(msl));
        System.out.println(Arrays.toString(msr));

//        we need minimum between msl and msr such that unit of water at each building is = minimum(msl & msr) - height of building
//        After that we are calculating the sum.
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            int min = Math.min(msl[i],msr[i]);
            int unit = min - arr[i];
            sum = sum + unit;
        }

        return sum;

    }

}

