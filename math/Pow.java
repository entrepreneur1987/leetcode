public class Solution {
    // recursion
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        boolean neg = n < 0? true: false;
        double p = pow(x, Math.abs(n));
        if(neg)
            return 1/p;
        return p;
    }
    
    private double pow(double x, int n){
        if(n==0)
            return 1;
        double p = pow(x, n/2);
        if(n%2==0){
            return p*p;
        }
        else{
            return x*p*p;
        }
    }
    
    // iteration
    public double myPow(double x, int n) {
        if(n==0)
            return 1.0;
        if(x==0)
            return 0;
        boolean neg = n < 0? true: false;
        n = Math.abs(n);
        double result = 1.0;
        while(n>0){
            if((n&1)==1){
                result*=x;
            }
            x*=x;
            n>>=1;
        }
        if(neg)
            return 1/result;
        return result;
    }
}
