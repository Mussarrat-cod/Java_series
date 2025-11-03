import java.util.HashMap;

public class Hash_exp {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> ages = new HashMap<>();

        // Add key-value pairs
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 22);

        // Access values
        System.out.println(ages.get("Alice"));  // Output: 25

        // Check for a key
        if (ages.containsKey("Bob")) {
            System.out.println("Bob is " + ages.get("Bob"));
        }

        // Remove an entry
        ages.remove("Charlie");

        // Iterate through entries
        for (String name : ages.keySet()) {
            System.out.println(name + " -> " + ages.get(name));
        }
    }
}
