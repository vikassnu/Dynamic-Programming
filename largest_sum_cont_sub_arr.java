package dynamic_programming;

import java.util.Scanner;

public class LSC_kadane {
    // Largest Subarray Sum Problem

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }*/ // for user input array;
        int[] a = {-3,5,4,-2,-1,1,3,-7,2,-8};
        System.out.println("max contigous sum: "+ max_contigous_sub_arr(a));
    }
    static int max_contigous_sub_arr(int a[]){
        int ar_size = a.length;
        int max_res = Integer.MIN_VALUE;
        int temp_max=0;
        for(int i=0;i<ar_size;i++){
            temp_max = temp_max + a[i];
            if(max_res<temp_max){max_res=temp_max;}
            if(temp_max<0){temp_max=0;}
        }
        return max_res;
    }
}

// Pseudo Code
/*
max = INT_MIN
temp_max = 0
loop(i=1 to size of array)
    1. temp_max = temp_max + a[i] // restart with new or continue with previous one
    2. if(max < temp_max): max = temp_max;
    3. if(temp_max < 0): temp_max = 0;  // greedy part

return max;    */
// Time Complexity: O(n)
// Auxiliary Space: O(1)

// can be viewed as greedy as well as DP