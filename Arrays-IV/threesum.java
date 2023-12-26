import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threesum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        // Sorting the array to make it easier to handle duplicates
        Arrays.sort(nums);
    
        for (int first = 0; first < nums.length - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
    
            int second = first + 1;
            int third = nums.length - 1;
    
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum < 0) {
                    second++;
                } else if (sum > 0) {
                    third--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[first]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    ans.add(temp);
    
                    // Handling duplicates
                    while (second < third && nums[second] == nums[second + 1]) {
                        second++;
                    }
                    while (second < third && nums[third] == nums[third - 1]) {
                        third--;
                    }
    
                    // Move both pointers to the next unique elements
                    second++;
                    third--;
                }
            }
        }
        return ans;
    }
    
}
