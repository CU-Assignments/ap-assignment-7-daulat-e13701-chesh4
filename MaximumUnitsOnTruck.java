import java.util.Arrays;

public class MaximumUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort boxTypes by number of units per box in descending order
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int maxUnits = 0;

        for (int[] box : boxTypes) {
            int boxCount = Math.min(truckSize, box[0]);
            maxUnits += boxCount * box[1];
            truckSize -= boxCount;
            if (truckSize == 0) break;
        }

        return maxUnits;
    }
}
