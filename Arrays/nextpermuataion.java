
public class nextpermuataion {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
            
        // Find the rightmost pair of elements in decreasing order
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
            
        if (i >= 0) {
            // Find the smallest element to the right of nums[i] that is greater than nums[i]
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
                
            // Swap nums[i] and nums[j]
            swap(nums, i, j);
        }
            
        // Reverse the subarray to the right of nums[i]
        reverse(nums, i + 1, nums.length - 1);

    }
        
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
        
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    
}
