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
    
    // binary search
    public int mySqrt(int x) {
        if(x<=0)
            return 0;
        int low = 1;
        int high = x/2+1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(mid <= x/mid && (mid+1)>x/(mid+1)){
                return mid;
            }
            else if(mid > x/mid){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return 0;
    }
    
    // newton's method
    public int mySqrt(int x) {
        double t = x;
        double epsilon = 1e-10;
        double lastT = 0;
        while(Math.abs(lastT-t) > epsilon*x){
            lastT = t;
            t = (t+x/t)/2;
        }
        return (int)t;
    }
    
    /***
     * double version
     **/
     
     // newton's method
     public double sqrt(double x) {
		double t = x;
		double lastT = 0;
		double epsilon = 1e-10;
		while (Math.abs(t - lastT) > epsilon * x) {
			lastT = t;
			t = (t + x / t) / 2;
		}
		return t;
	}
	
	// binary search
	public double sqrtBinarySearch(double x) {
		if (x <= 0)
			return 0;
		if (x == 1)
			return 1;
		double low = 0;
		double high = x > 1 ? x : 1;
		double epsilon = 1e-10;
		while (Math.abs(low - high) > epsilon * x) {
			double mid = (low + high) / 2;
			if (Math.abs(mid * mid - x) < epsilon * x)
				return mid;
			if (mid * mid - x > epsilon * x)
				high = mid;
			else
				low = mid;
		}
		return 0;
	}
	
	
}
