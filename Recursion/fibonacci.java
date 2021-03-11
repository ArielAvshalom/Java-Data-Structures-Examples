//package Recursion;

public class fibonacci {
    //0,1,1,2
    public static int fib(int n) {
        if (n == 2) {
            return 1;
        }
        //it's much clearer to have several if and no nested elses if you can avoid.
        if (n == 1){
            return 0;
        }
        //System.out.println("We are now in position " + n + " we will be doing fib on " + (n-1) +", " +  (n-2));
        return fib(n - 1) + fib(n -2);
        // 0,1,1,2 : 1 +1 = 2, 1+2 = 3, 2+3 = 5
    }

    public static void main(String[] args) {
        System.out.println(fib(1000));
        
    }
        
}