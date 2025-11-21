import java.util.PriorityQueue;

public class HeapExample {
    public static void main(String[] args) {
        // Min-heap (default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        System.out.println("Min: " + minHeap.poll()); // Output: 5 (removes smallest)
        
        // Max-heap (using reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);
        System.out.println("Max: " + maxHeap.poll()); // Output: 20
    }
}
