package dynamic_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fib_naive {
    static int fib_simple(int n){
        if(n<=1){return n;}
        else{
            return fib_simple(n-1)+fib_simple(n-2);
        }
    }// using recursion
    /*static int fib_t_b(int n){
        List<Integer> memo = new ArrayList<>();
        memo.add(0);
        memo.add(1);
        if(memo.size()==n+1){
            return memo.get(n);
        }
        else{
            memo.add(n, fib_t_b(n-2) + fib_t_b(n-1));
            return memo.get((n));
        }
    }*/
    int[] cache;
    fib_naive(int[] cache){
        this.cache = cache;
    }
    int fib_t_b(int n){
        if(cache[n]==0){
            if(n<2) cache[n]=n;
            else cache[n] = fib_t_b(n-1)+fib_t_b(n-2);
        }
        return cache[n];
    } // top to bottom
    static int fib_b_t(int n){
        final int max = 10009;
        int[] fib = new int[max];
        if(n==0) return 0;
        if(n==1) return 1;
        if(fib[n]!=0){
            return fib[n];
        }
        fib[n]=fib_b_t(n-1)+fib_b_t(n-2);
        return fib[n];
    }//bottom to top
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fib_simple(n);
        /*for(int i=1;i<=n;i++){
        System.out.print(fib_simple(i)+",");
         }*/
        System.out.println(fib_b_t(n));
        System.out.println(fib_simple(n));
        System.out.println(new fib_naive(new int[n+1]).fib_t_b(n));

    }
}
