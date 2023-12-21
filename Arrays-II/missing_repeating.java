// https://www.codingninjas.com/studio/problems/873366?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
import java.util.ArrayList;
public class missing_repeating {
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int[] newarr = new int[n]; // no need for O(n) space if we modify cycle to accept arraylist
        for (int i = 0; i < n; i++) {
            newarr[i] = arr.get(i);
        }
        cycle(newarr);
        for (int i = 0; i < n; i++) {
            if (i + 1 != newarr[i])  {
                return new int[]{i+1 , newarr[i]};
            }
        }
        return new int[]{-1,-1};

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
