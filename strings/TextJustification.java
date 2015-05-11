public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
       List<String> ret = new ArrayList<String>();
       int len = 0;
       List<String> buff = new ArrayList<String>();
       for(String w : words){
           if(len + buff.size() + w.length() <= maxWidth){
               buff.add(w);
               len+=w.length();
           }
           else{
               StringBuilder tmp = new StringBuilder();
               int spaces = maxWidth - len;
               if(buff.size()==1){
                    tmp.append(buff.get(0));
                    appendSpaces(tmp, spaces);
               }
               else{
                   int avgSpaces = spaces/(buff.size()-1);
                   int leftSpaces = spaces - avgSpaces*(buff.size()-1);
                   for(int i=0; i<buff.size()-1; i++){
                       String cw = buff.get(i);
                       tmp.append(cw);
                       appendSpaces(tmp, avgSpaces);
                       if(leftSpaces > 0){
                            appendSpaces(tmp, 1);
                            leftSpaces--;
                       }
                   }
                   tmp.append(buff.get(buff.size()-1));
               }
               len = w.length();
               buff.clear();
               buff.add(w);
               ret.add(tmp.toString());
           }
       }
       StringBuilder tmp = new StringBuilder();
       boolean hasWord = false;
       for(String cw: buff){
           hasWord = true;
           tmp.append(cw+" ");
       }
       if(tmp.length() > maxWidth){
           tmp.deleteCharAt(tmp.length()-1);
       }
       else{
           appendSpaces(tmp, maxWidth-tmp.length());
       }
       if(hasWord)
           ret.add(tmp.toString());
        return ret;
    }
    
    
    
    private void appendSpaces(StringBuilder tmp, int n){
        for(int i=0; i<n; i++)
            tmp.append(" ");
    }
}
