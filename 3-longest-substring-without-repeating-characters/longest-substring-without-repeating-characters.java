class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128]; 
        int maxLength = 0;
        
        for (int left = 0, right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // Move the left pointer to the right of the last seen duplicate
            left = Math.max(lastSeen[currentChar], left);
            
            // Calculate the current window size and update max
            maxLength = Math.max(maxLength, right - left + 1);
            
            // Store the next index (1-based) to jump the left pointer to
            lastSeen[currentChar] = right + 1;
        }
        
        return maxLength;
    }
}