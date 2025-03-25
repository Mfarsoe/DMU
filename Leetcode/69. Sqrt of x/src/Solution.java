class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;  // Base cases for 0 and 1

        int low = 1, high = x, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid; // Avoid integer overflow

            if (square == x) return mid; // Perfect square case
            if (square < x) {
                ans = mid; // Store possible answer
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans; // Return the floored square root
    }
}
