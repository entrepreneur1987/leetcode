public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> ret = new HashSet<String>();
        Set<Integer> track = new HashSet<Integer>();
        for(int i=0; i<=s.length()-10; i++){
            String t = s.substring(i, i+10);
            int code = encode(t);
            if(track.contains(code)){
                ret.add(t);
            }
            else{
                track.add(code);
            }
        }
        List<String> result = new ArrayList<String>();
        for(String t: ret){
            result.add(t);
        }
        return result;
    }
    
    private int encode(String s){
        if(s.length()!=10)
            return -1;
        int code = 0;
        for(char c: s.toCharArray()){
            code<<=2;
            code |= getCode(c);
        }
        return code;
    }
    
    private int getCode(char c){
        if(c == 'A'){
            return 0;
        }
        else if(c == 'C'){
            return 1;
        }
        else if(c=='G'){
            return 2;
        }
        else{
            return 3;
        }
    }
}
