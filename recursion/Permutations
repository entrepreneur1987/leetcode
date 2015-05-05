public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        recSolve(ret, new ArrayList<Integer>(), new boolean[nums.length], nums, 0);
        return ret;
    }
    
    private void recSolve(List<List<Integer>> ret, List<Integer> buff, boolean[] used, int[] nums, int index){
        if(index == nums.length){
            ret.add(new ArrayList<Integer>(buff));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!used[i]){
                used[i] = true;
                buff.add(nums[i]);
                recSolve(ret, buff, used, nums, index+1);
                used[i] = false;
                buff.remove(buff.size()-1);
            }
        }
    }
}
