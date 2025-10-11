import java.util.*;

public class SortCollections {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Ravi", "Amit", "Karan", "Sneha"));
        Collections.sort(names);
        System.out.println(names);
    }
}
