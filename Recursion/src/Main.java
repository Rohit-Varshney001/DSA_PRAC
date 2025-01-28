import java.util.ArrayList;
import java.util.HashSet;

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

//        Permutations of a String
        System.out.println(findPermutations("aac"));

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

    public static ArrayList<String> findPermutations(String s){
        ArrayList<String> lst = new ArrayList<>();
        findComb(s,"",lst);
        return lst;

    }
    public static void findComb(String input, String output, ArrayList<String> lst){
        if(input.isEmpty()){
            lst.add(output);
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int  i =0; i<input.length(); i++){
            Character currentChar = input.charAt(i);
        //  To skip the iteration for the duplicate chars like: aab.
            if(!set.contains(currentChar)){
                set.add(currentChar);
                String newInp = input.substring(0,i) + input.substring(i+1);
                String newOut = output + currentChar;
                findComb(newInp, newOut, lst);
            }
        }
    }



}