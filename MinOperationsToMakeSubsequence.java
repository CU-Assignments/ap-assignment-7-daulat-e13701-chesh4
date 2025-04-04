import java.util.HashMap;
import java.util.Map;

public class MinOperationsToMakeSubsequence {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            positionMap.put(target[i], i);
        }

        int[] lis = new int[arr.length];
        int length = 0;

        for (int num : arr) {
            if (positionMap.containsKey(num)) {
                int pos = positionMap.get(num);
                int idx = binarySearch(lis, length, pos);
                lis[idx] = pos;
                if (idx == length) {
                    length++;
                }
            }
        }

        return target.length - length;
    }

    private int binarySearch(int[] lis, int length, int key) {
        int low = 0, high = length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (lis[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
           
::contentReference[oaicite:18]{index=18}
 
