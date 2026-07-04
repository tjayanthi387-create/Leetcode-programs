public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] nums1 = {1, 2, 0};
        System.out.println("Example 1 Output: " + solver.firstMissingPositive(nums1)); 
        int[] nums2 = {3, 4, -1, 1};
        System.out.println("Example 2 Output: " + solver.firstMissingPositive(nums2)); 
        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println("Example 3 Output: " + solver.firstMissingPositive(nums3)); 
    }
}
