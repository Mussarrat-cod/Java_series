import java.util.LinkedList;

public class LinkedList {
    public static void main(String[] args) {
        // Create a LinkedList of strings
        LinkedList<String> list = new LinkedList<>();
        
        // Adding elements to the LinkedList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("Initial List: " + list);
        
        // Adding elements at the beginning and end
        list.addFirst("Mango");
        list.addLast("Pineapple");
        System.out.println("After adding elements at the beginning and end: " + list);
        
        // Removing elements
        list.removeFirst();  // Removes "Mango"
        list.removeLast();   // Removes "Pineapple"
        list.remove("Banana"); // Removes "Banana"
        System.out.println("After removals: " + list);
        
        // Get the first and last elements
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
    }
}
