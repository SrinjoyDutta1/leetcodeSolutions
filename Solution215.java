import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        return quickSelect(nums, 0, nums.length-1,  nums.length-k);
    }
    public int quickSelect(int[]nums, int left, int right, int k) {
        if (left == right) return nums[left];
        Random rand = new Random();
        int pivot = left+rand.nextInt(right-left+1);
        pivot = partition(nums, left, right, pivot);
        if (pivot == k) {
            return nums[pivot];
        } else if (pivot > k) {
            return quickSelect(nums, left, pivot-1,k);
        } else {
            return quickSelect(nums, pivot+1, right,k);
        }
 
        
    }
    public int partition(int nums[], int left, int right, int pivot) {
        int iTrack = left;
        int pivNum = nums[pivot];
        swap(nums,pivot,right);
        for (int i = left; i < right; i++) {
            if (nums[i] < pivNum) {
                swap(nums, i,iTrack);
                iTrack++;
            }
        }
        swap(nums, iTrack, right);
        return iTrack;
    }
    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
