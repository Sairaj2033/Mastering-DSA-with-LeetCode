class Solution {
    public String convert(String s, int numRows) {
        // Base case: if 1 row or string is shorter than numRows, no zigzag needed
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Create an array of StringBuilders for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = false;

          for (char c : s.toCharArray()) {
            rows[currRow].append(c);
            
           
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
        
            currRow += goingDown ? 1 : -1;
        }

        
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}