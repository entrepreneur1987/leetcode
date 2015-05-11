public class Solution {
    // recursion
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }
    
    private boolean isMatch(String s, int sIndex, String p, int pIndex){
        if(p.length() == pIndex)
            return sIndex == s.length();
        if(pIndex < p.length()-1 && p.charAt(pIndex+1) == '*'){
            while(sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')){
                if(isMatch(s, sIndex, p, pIndex+2))
                    return true;
                sIndex++;
            }
            return isMatch(s, sIndex, p, pIndex+2);
        }
        else{
            if(sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.'))
                return isMatch(s, sIndex+1, p, pIndex+1);
            return false;
        }
    }
    
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=2; i<=p.length(); i+=2){
            if(p.charAt(i-1) == '*')
                dp[0][i] = true;
            else
                break;
        }
        
        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=p.length(); j++){
                if(p.charAt(j-1)=='*'){
                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2)=='.'){
                        dp[i][j] = dp[i][j-2] || dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i][j-2];
                    }
                }
                else{
                    if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                        dp[i][j] = dp[i-1][j-1];
                }
            } 
        }
        return dp[s.length()][p.length()];
    }

}
