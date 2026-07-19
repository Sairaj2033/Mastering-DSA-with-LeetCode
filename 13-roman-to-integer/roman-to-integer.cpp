class Solution {
public:
    int romanToInt(string s) {
        //sairaj
        unordered_map<char, int> roman = {
            {'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, 
            {'C', 100}, {'D', 500}, {'M', 1000}
        };
        
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            // If current numeral is smaller than the next, subtract it
            if (i < s.length() - 1 && roman[s[i]] < roman[s[i + 1]]) {
                sum -= roman[s[i]];
            } else {
                // Otherwise, add it
                sum += roman[s[i]];
            }
        }
        
        return sum;
    }
};
