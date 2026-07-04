import java.util.Arrays;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < nums1.length; i++) {
            int ind = -1;

            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    ind = j;
                    break;
                }
            }

            for (int k = ind + 1; k < nums2.length; k++) {
                if (nums2[k] > nums2[ind]) {
                    res[i] = nums2[k];
                    break;
                }
            }
        }

        return res;
    }
}