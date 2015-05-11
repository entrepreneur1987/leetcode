public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int im = m-1;
        int in = n-1;
        int ig = m+n-1;
        while(im >=0 && in >=0){
            if(nums1[im] > nums2[in]){
                nums1[ig--] = nums1[im--];
            }
            else{
                nums1[ig--] = nums2[in--];
            }
        }
        while(in>=0){
            nums1[ig--] = nums2[in--];
        }
    }
}
