public class mergesorted {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Index for the last element in nums1
        int j = n - 1; // Index for the last element in nums2
        int k = m + n - 1; // Index for the last position in nums1

        // Merge elements from nums1 and nums2 in reverse order
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // Add any remaining elements from nums2, if there are any
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
