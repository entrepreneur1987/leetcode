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
    
    // span from middle
    public String longestPalindrome(String s) {
        String longest = "";
        for(int i=0; i<2*s.length()-1; i++){
            int left = i/2;
            int right = i/2;
            if(i%2==1)
                right++;
            String t = longestPalindrome(s, left, right);
            if(t.length() > longest.length()){
                longest = t;
            }
        }
        return longest;
    }
    
    private String longestPalindrome(String s, int left, int right){
        while(left >=0 && right<s.length()){
            if(s.charAt(left) != s.charAt(right))
                break;
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
