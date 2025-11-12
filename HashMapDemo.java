import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // 1. Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // 2. Add key-value pairs
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        // 3. Print entire HashMap
        System.out.println("Initial HashMap: " + map);

        // 4. Access value by key
        System.out.println("Value for 'Banana': " + map.get("Banana"));

        // 5. Update a value
        map.put("Banana", 25); // Updates Banana's value
        System.out.println("Updated HashMap: " + map);

        // 6. Remove a key-value pair
        map.remove("Apple");
        System.out.println("After removing 'Apple': " + map);

        // 7. Check existence of key and value
        System.out.println("Contains key 'Orange'? " + map.containsKey("Orange"));
        System.out.println("Contains value 30? " + map.containsValue(30));

        // 8. Iterate over entries
        System.out.println("Iterating over keys and values:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 9. Print all keys and values separately
        System.out.println("All keys: " + map.keySet());
        System.out.println("All values: " + map.values());
        
        // 10. Size of the map
        System.out.println("Size: " + map.size());
    }
}
