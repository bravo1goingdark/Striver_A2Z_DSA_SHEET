public class count_inversion {
    public static long getInversions(long arr[], int n) {
        // Create a temporary array to store the merged sorted array
        long[] temp = new long[n];
        
        // Call the merge sort function to count inversions
        return mergeSortAndCount(arr, temp, 0, n - 1);
    }

    private static long mergeSortAndCount(long arr[], long temp[], int left, int right) {
        long invCount = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            // Recursive calls to divide the array
            invCount += mergeSortAndCount(arr, temp, left, mid);
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);

            // Merge the divided arrays and count inversions
            invCount += merge(arr, temp, left, mid, right);
        }

        return invCount;
    }

    private static long merge(long arr[], long temp[], int left, int mid, int right) {
        int i = left; // Index for the left subarray
        int j = mid + 1; // Index for the right subarray
        int k = left; // Index for the merged array
        long invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // If the element in the left subarray is greater, it forms inversions with the elements in the right subarray
                temp[k++] = arr[j++];
                invCount += mid - i + 1;
            }
        }

        // Copy the remaining elements from the left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements from the right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the merged elements back to the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }
}
