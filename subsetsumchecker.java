package dynamic_programming;

public class subset_sum_checker{
    // Problem:
    /*
    * set: {3,33,53,64,24,5,2}, sum=9
    * output: True
    * */
    // Naive Method
    static boolean issubsetsum(int arr[], int n, int sum){
        if(sum ==0)
            return true;
        if(n == 0)
            return false;
        if(arr[n-1]>sum)
            return issubsetsum(arr,n-1,sum);
        return issubsetsum(arr,n-1,sum) || issubsetsum(arr,n-1,sum-arr[n-1]);

    }
    // Dynamic Programming
    static boolean issubsetsum_dp(int arr[],int n, int sum){
        boolean checker[][] = new boolean[sum+1][n+1];
        for(int i=0;i<=n;i++)
            checker[0][i]=true;
        for (int j=1;j<=sum;j++)
            checker[j][0]=false;
        for (int i=1;i<=sum;i++){
            for(int j=1;j<=n;j++){
                checker[i][j]=checker[i][j-1];
                if(i>=arr[j-1])
                    checker[i][j] = checker[i][j] || checker[i-arr[j-1]][j-1];
            }
        }
        return checker[sum][n];
    }

    public static void main(String[] args) {
        int arr[] = {43,52,2,25,53,235,62,2,25,2,52,25,62,52,1,23,62,26,23,62,86,2};
        int sum=50;
        int n = arr.length;
        if(issubsetsum(arr,n,sum)==true){
            System.out.println("subset sum exist");

        }
        else {
            System.out.println("NO");
        }
        System.out.println("Solution using  dp");

        if(issubsetsum_dp(arr,n,sum)==true){
            System.out.println("subset sum exist");

        }
        else {
            System.out.println("NO");
        }
    }
}
