public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null){
            return ret;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int currLevel = 1;
        int nextLevel = 0;
        List<Integer> data = new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            data.add(curr.val);
            currLevel--;
            if(curr.left!=null){
                q.add(curr.left);
                nextLevel++;
            }
            if(curr.right!=null){
                q.add(curr.right);
                nextLevel++;
            }
            if(currLevel==0){
                ret.add(data);
                data = new ArrayList<Integer>();
                currLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return ret;
    }
}
