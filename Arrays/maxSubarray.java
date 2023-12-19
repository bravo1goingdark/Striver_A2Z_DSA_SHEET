public class maxSubarray {
    
    public int maxSubArray(int[] nums) {
        return kadane(nums);
    }
    public int kadane(int[] nums){
        int maxsum = nums[0];
        int currsum = 0;

        for (int num : nums) {
            currsum = Math.max(currsum, 0);
            currsum += num;
            maxsum = Math.max(maxsum, currsum);
        }
        return maxsum;
    }
}
