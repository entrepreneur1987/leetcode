public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int sum = nums[0], max = nums[0];
        for(int i=1; i<nums.length; i++){
            sum = Math.max(sum+nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
    
    public int maxSubArrayWithPos(int[] nums) {
		if (nums.length == 0)
			return 0;
		int sum = nums[0], max = nums[0], start = 0, end = 0, maxStart = 0, maxEnd = 0;
		for (int i = 1; i < nums.length; i++) {
			if (sum + nums[i] > nums[i]) {
				end = i;
				sum += nums[i];
			} else {
				start = i;
				end = i;
				sum = nums[i];
			}

			if (sum > max) {
				maxStart = start;
				maxEnd = end;
				max = sum;
			}
		}
		System.out.println("start: " + maxStart);
		System.out.println("end: " + maxEnd);
		return max;
	}
}
