class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right) {
            return left; 
        }

        int middle = (left + right) / 2;
        if (nums[middle] > nums[middle+1]){ 
            return helper(nums, left, middle);
        } else {
            return helper(nums, middle+1, right);
        }

    }
}
