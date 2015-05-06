public class Solution {
    // dp solution
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            dp[i][i] = true;
        }
        
        int maxStart = 0, maxLen = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j>=0; j--){
                if(s.charAt(i) == s.charAt(j) && (i-j<2 || dp[j+1][i-1])){
                    dp[j][i] = true;
                    if(i-j+1>maxLen){
                        maxLen = i-j+1;
                        maxStart = j;
                    }
                }
            }
        }
        return s.substring(maxStart, maxStart+maxLen);
    }
}
