import java.util.HashSet;

public class longestseq {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {  // Only start counting from the smallest element in a potential sequence
                int currentNum = num;
                int count = 1;

                // Check for consecutive sequence forward
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longestStreak = Math.max(longestStreak, count);
            }
        }

        return longestStreak;
    }
}