def LCS_naiv(X,Y,m,n):
        if m == 0 or n == 0:
            return 0
        elif X[m-1] == Y[n-1]:
            return 1 + LCS_naiv(X,Y,m-1,n-1)
        else:
            return max(LCS_naiv(X,Y,m-1,n),LCS_naiv(X,Y,m,n-1))
def LCS_dp(X,Y,m,n,dp):
    if m == 0 or n==0:
        return 0
    if dp[m][n] != -1:
        return dp[m][n]
    if X[m-1] == Y[n-1]:
        dp[m][n] = 1 + LCS_dp(X,Y,m-1,n-1,dp)
        return dp[m][n]
    else:
        dp[m][n] = max(LCS_dp(X,Y,m-1,n,dp),LCS_dp(X,Y,m,n-1,dp))
        return dp[m][n]

X = "ASNAJDSKCNSJN"
Y = "SHKJDSNJDSNDSDSJCBJH"
n = len(Y)
m = len(X)
dp = [[-1 for i in range(n+1)] for j in range(m+1)]
print("leghth of LCS is ",LCS_naiv(X,Y,len(X),len(Y)))
print()
print("leghth of LCS is ",LCS_dp(X,Y,m,n,dp))
print()

"""
Problem
    /*
    * seq 1:   ABCDGH  & AEDFHR
    * seq 2:   AGGTAB  & GXTXAYB
    * longest common:  seq 1: ADH
    * longest common: seq 2: GTAB
    * */
    //Naive Method
    """






