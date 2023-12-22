public class majorityelement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majorityElement = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                majorityElement = nums[i];
            } else if (nums[i] == majorityElement) {
                count++;
            } else {
                count--;
            }
        }
        int verifiable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majorityElement) {
                verifiable++;
            }
        }
        if (verifiable > (nums.length) / 2) {
            return majorityElement;
        }
        return -1;
    }
}
