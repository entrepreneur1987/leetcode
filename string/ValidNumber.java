public class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.trim().isEmpty())
            return false;
        s = s.trim();
        if(s.charAt(0) == '+' || s.charAt(0) == '-')
            s = s.substring(1);
        boolean num = false, dot = false, e = false;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = true;
            }
            else if(c == '.'){
                if(dot || e)
                    return false;
                dot = true;
            }
            else if(c == 'e'){
                if(!num || e)
                    return false;
                e = true;
                num = false;
            }
            else if(c == '+' || c== '-'){
                if(i==0 || s.charAt(i-1)!='e')
                    return false;
            }
            else{
                return false;
            }
        }
        return num;
    }
}
