public class reversepair {
    public int reversePairs(int[] nums) {
        return inPlaceMergeSort(nums, 0, nums.length - 1);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temporary arrays left[] and right[]
        for (int i = 0; i < n1; ++i)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = arr[m + 1 + j];

        // Merge the temporary arrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left[], if any
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of right[], if any
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static int inPlaceMergeSort(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            // Same as (l+r)/2, but avoids overflow for large l and r
            int m = l + (r - l) / 2;

            // Sort first and second halves
            count += inPlaceMergeSort(arr, l, m);
            count += inPlaceMergeSort(arr, m + 1, r);
            count += countPairs(arr, l, m, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return count;
    }

    private static int countPairs(int[] arr, int l, int m, int r) {
        int count = 0;
        int right = m + 1;

        for (int i = l; i <= m; i++) {
            while (right <= r && arr[i] > 2 * (long) arr[right]) {
                right++;
            }
            count += (right - (m + 1));
        }
        return count;
    }
    
}
