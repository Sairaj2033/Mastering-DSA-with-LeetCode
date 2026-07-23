class Solution {
    public boolean isPalindrome(int x) {
        // Edge cases: 
        // 1. All negative numbers are NOT palindromes (because of the '-' sign).
        // 2. If a number ends with 0, the first digit must also be 0. 
        //    Only the number 0 itself satisfies this, so return false for others.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        
        // Reverse the second half of the number
        // We know we've reached the middle when x is less than or equal to revertedNumber
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an even number, x == revertedNumber
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber / 10
        // (For example, if input is 12321, at the end x = 12 and revertedNumber = 123)
        return x == revertedNumber || x == revertedNumber / 10;
    }
}