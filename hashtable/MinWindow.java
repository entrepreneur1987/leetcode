public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> track = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()){
            if(track.containsKey(c)){
                track.put(c, track.get(c)+1);
            }
            else{
                track.put(c, 1);
            }
        }
        int left=0, minStart=0, minLength=s.length()+1, count=0;
        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            if(track.containsKey(c1)){
                if(track.get(c1) > 0)
                    count++;
                track.put(c1, track.get(c1)-1);
            }
            while(count == t.length()){
                if(i-left+1 < minLength){
                    minStart = left;
                    minLength = i-left+1;
                }
                char c2 = s.charAt(left);
                if(track.containsKey(c2)){
                    if(track.get(c2) >= 0){
                        count--;
                    }
                    track.put(c2, track.get(c2)+1);
                }
                left++;
            }
        }
        if(minLength == s.length()+1)
            return "";
        return s.substring(minStart, minStart+minLength);
    }
}
