
public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // --- Insertion Method ---

    /**
     * Inserts a new value into the BST.
     * @param data The value to insert.
     */
    public void insert(int data) {
        root = insertRec(root, data);
    }

    /**
     * A recursive helper function to insert a new node.
     */
    private Node insertRec(Node root, int data) {
        // 1. If the tree (or subtree) is empty, return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        /* 2. Otherwise, recur down the tree */
        if (data < root.data) {
            // New data is smaller, go left
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            // New data is larger, go right
            root.right = insertRec(root.right, data);
        }
        
        // Return the (unchanged) node pointer
        return root;
    }

    // --- Traversal Method (In-order) ---

    /**
     * Public method to start the In-order traversal.
     */
    public void inorder() {
        System.out.print("In-order Traversal (Sorted): ");
        inorderRec(root);
        System.out.println();
    }

    /**
     * A recursive helper function for In-order traversal: Left -> Root -> Right.
     */
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);       // 1. Traverse left subtree
            System.out.print(root.data + " "); // 2. Visit root
            inorderRec(root.right);      // 3. Traverse right subtree
        }
    }

    // --- Main method to test the BST ---

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Insert values to build the BST */
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        /* The tree structure will be:
              50
             /  \
            30   70
           / \  / \
          20 40 60 80
        */

        // Print the in-order traversal (which should be sorted)
        tree.inorder(); // Output: 20 30 40 50 60 70 80 
    }
}
