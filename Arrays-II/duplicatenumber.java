public class duplicatenumber {
    public int findDuplicate(int[] nums) {
        cycle(nums);
        return nums[nums.length - 1];
    }
    public static void cycle(int[] arr){ // only applicable for positive natural number tracker.e (0 , n-1) or (1,n)
        int tracker = 0;
        while(tracker < arr.length){
            int index = arr[tracker] - 1;
            if(arr[tracker] != arr[index]){
                swap(arr , tracker , index);
            }else {
                tracker++;
            }
        }
    }
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
