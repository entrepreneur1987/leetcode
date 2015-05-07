public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        int max_local = nums[0];
        int min_local = nums[0];
        int max_global = nums[0];
        for(int i=1; i<nums.length; i++){
            int t = max_local;
            max_local = Math.max(Math.max(max_local*nums[i], min_local*nums[i]), nums[i]);
            min_local = Math.min(Math.min(t*nums[i], min_local*nums[i]), nums[i]);
            max_global = Math.max(max_global, max_local);
        }
        return max_global;
    }
}
