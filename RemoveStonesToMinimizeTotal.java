import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTotal {
    public int minStoneSum(int[] piles, int k) {
        // Max heap to store the piles
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int totalStones = 0;

        // Add all piles to the max heap and calculate the total number of stones
        for (int pile : piles) {
            maxHeap.add(pile);
            totalStones += pile;
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            int largestPile = maxHeap.poll();
            int stonesRemoved = largestPile / 2;
            totalStones -= stonesRemoved;
            maxHeap.add(largestPile - stonesRemoved);
        }

        return totalStones;
    }
}
