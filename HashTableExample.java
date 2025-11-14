import java.util.HashMap;
import java.util.Map;

public class HashTableExample {
    public static void main(String[] args) {
        // Create a HashMap with String keys and Integer values
        Map<String, Integer> hashTable = new HashMap<>();
        
        // Put operations
        hashTable.put("apple", 1);
        hashTable.put("banana", 2);
        hashTable.put("cherry", 3);
        
        // Get operation
        System.out.println("Value for 'apple': " + hashTable.get("apple"));  // Output: 1
        
        // Check if key exists
        System.out.println("Contains 'banana': " + hashTable.containsKey("banana"));  // true
        
        // Remove operation
        hashTable.remove("cherry");
        System.out.println("Size after removal: " + hashTable.size());  // 2
        
        // Iterate over entries
        for (Map.Entry<String, Integer> entry : hashTable.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
