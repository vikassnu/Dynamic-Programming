package dynamic_programming;
// find: length of the largest increasing subset;
public class Largest_Increasing_sub_seq {
    // Recursion:
    /*1. length of lIS end with arr[n-1]; ---using  temp_max
    2. global max may end before arr[n-1]:--using final_max
    3. result: final_max
    4. Time complexity: exponential
    5. Auxiliary Space: O(1)*/

    static int final_max;
    static int LIS_rec(int arr[], int n){
        if(n==1){
            return 1;
        }
        int res;
        int temp_max=1;
        for(int i=1;i<n;i++){
            res=LIS_rec(arr,i );
            if(arr[i-1]<arr[n-1] && res + 1 > temp_max){ temp_max=res+1;}
        }
        if(final_max < temp_max){
            final_max =temp_max;
        }
        return temp_max;
    }
    static int LIS_rec_(int arr[], int n){
        final_max = 1;
        LIS_rec(arr, n);
        return final_max;
    }

    // Dynamic Programming:
       /*
       1. overlapping substructure property solve using
       2. Memoization or Tabulation
       3. Time Complexity: O(n^2)
       4. Auxiliary Space: O(n)
       */
    static int LIS_DP(int arr[], int n){
        int a[] = new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            a[i]=1;
        }
        for(int j=1;j<n;j++){
            for(int k=0;k<j;k++){
                if(arr[j]>arr[k] && a[j]<a[k]+1){a[j]=a[k]+1;}
            }
        }
        for(int j=0;j<n;j++){
            if(max<a[j]){max = a[j];}
        }
        return max;
    }
    // advanced DP(O(nlogn))
    /*1.time_complexity(nlogn)
    2.space: O(n)
    3. cases: (added element: 1.largest among all ele of seq(add to list with largest seq) and clone
                               2.smallest(start with new)
                               3.in between(replace with last ele to seq whoose ele's is less than added one except for last) 
    3. algorithm("https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/") */   
    static int ceil_i(int a[],int l,int r, int key){
        while (r-l > 1){
            int m = l + (r-l)/2;
            if(a[m]>=key){
                r=m;
            }
            else{l=m;}


        }
        return r;

    }
    static int LIC_adv_dp(int A[], int size){
        int[] table = new int[size];
        table[0] = A[0];
        int len=1;
        for(int i=0;i<size;i++){
            if(A[i]<table[0]){
            table[0]=A[i];}
            else if(A[i]>table[len-1]){
                table[len++]=A[i];
            }
            else {
                table[ceil_i(table, -1, len-1, A[i])] =A[i];
            }

        }
        return len;


    }



    public static void main(String[] args) {
        int arr[] = {32,42,73,6,2,3,23,7,52,87,90};
        int n = arr.length;
        System.out.println("length of LIC_rec:"+LIS_rec_(arr, n));
        System.out.println("length of LIC_dp:"+LIS_DP(arr, n));
        System.out.println("length of LIC_dp:"+LIC_adv_dp(arr, n));

        /*int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }*/ // for user input array;
    }

}
