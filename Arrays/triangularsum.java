public class triangularsum {
    public static void main(String[] args) {
        System.out.println(triangularSum(new int[]{1,2,3,4,5}));
    }
    public static int triangularSum(int[] nums) {
        while (nums.length > 1) {
            int[] newarr = new int[nums.length - 1];

            for (int i = 0; i < nums.length - 1; i++) {
                newarr[i] = (nums[i] + nums[i + 1]) % 10;
            }

            nums = newarr; // Update the nums array for the next iteration
        }

        return nums[0];
    }
}
