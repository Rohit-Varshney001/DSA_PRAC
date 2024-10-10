import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int [] arr = {45,36,85,12,23};
        System.out.println(MonotonicStack(arr));
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
}

