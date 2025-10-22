import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Create a Stack of integers
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the stack
        System.out.println("Stack after pushes: " + stack);

        // Pop an element from the stack
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);

        // Display the stack after pop
        System.out.println("Stack after pop: " + stack);

        // Peek at the top element without removing it
        int topElement = stack.peek();
        System.out.println("Top element (peek): " + topElement);

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + stack.isEmpty());
    }
}
