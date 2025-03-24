class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int org = x;
        int rev = 0;
        int rem;

        while (x > 0) {
            rem = x % 10;
            rev = (rev * 10) + rem;
            x = x / 10;
            System.out.println(""+x+" "+rev);
        }
        if(rev == org) return true;
        return false;
    }
}