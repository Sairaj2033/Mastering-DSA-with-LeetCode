class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] represents the minimum edit distance between the 
        // first i characters of word1 and the first j characters of word2.
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case 1: Converting to an empty string requires deleting all characters.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        
        // Base case 2: Converting from an empty string requires inserting all characters.
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the characters match, no new operation is needed.
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; 
                } 
                // If they don't match, take the minimum of the three possible operations.
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],    // Replace
                                   Math.min(dp[i - 1][j],        // Delete
                                            dp[i][j - 1]));      // Insert
                }
            }
        }
        
        return dp[m][n];
    }
}