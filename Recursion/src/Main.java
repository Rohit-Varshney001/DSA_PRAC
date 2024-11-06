public class Main {
    public static void main(String[] args) {
        int n = 10;
//        Print 1 to n
        print1ToN(n);

//        Print N To 1
        printNTo1(n);

//        Factorial
        System.out.println("Factorial---> "+factorial(5));
        System.out.println("Hello world!");
    }

    public static void print1ToN(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        print1ToN(n-1);
        System.out.println(n);
    }

    public static void printNTo1(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printNTo1(n-1);
    }

    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }
}