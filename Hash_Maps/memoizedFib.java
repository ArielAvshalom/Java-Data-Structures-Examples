import java.util.*;

public class memoizedFib {
    public static int fib(int n) {
        Map<Integer, Integer> memoize = new HashMap<Integer, Integer>();
        memoize.put(1, 0);
        memoize.put(2,1);
        return fib(n, memoize);
    }

    public static int fib(int n, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(n)) {
            return memoize.get(n);
        } else {
            memoize.put(n, fib(n-1, memoize) + fib(n-2, memoize));
            return memoize.get(n);
        }
    }
    public static void main(String[] args) {
        System.out.println(fib(1000));
    }
}
