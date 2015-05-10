public class Solution {
    // topcoder: binary search
    public int mySqrt(int x) {
        if(x==1)
            return 1;
        if(x<=0)
            return 0;
        int low = 0;
        int high = x/2+1;
        while(low<high){
            int mid = low+(high-low+1)/2;
            if(p(mid, x)){
                high = mid-1;
            }
            else{
                low = mid;
            }
        }
        if(p(low, x))
            return 0;
        return low;
    }
    
    private boolean p(int t, int x){
        return t > x/t;
    }
}
