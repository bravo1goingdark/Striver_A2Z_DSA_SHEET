import java.util.Arrays;

public class mergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));
        int index = 0; // Index to track the position for merged intervals

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[index];
            int[] nextInterval = intervals[i];

            // If the current interval overlaps with the next one, merge them
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // If no overlap, move to the next position and update the interval
                index++;
                intervals[index] = nextInterval;
            }
        }

        // Return the merged intervals (up to the index position)
        return Arrays.copyOf(intervals, index + 1);

    }
}
