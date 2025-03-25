class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int first=1;
        int second=2;
        for(int i=1;i<=n-2;i++){ //using Fibonacci approach
            int temp=first+second;
            first=second;
            second=temp;
        }
        return second;
    }
}