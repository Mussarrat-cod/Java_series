class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class BSTExample {
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BSTExample bst = new BSTExample();
        TreeNode root = null;
        root = bst.insert(root, 5);
        bst.insert(root, 3);
        bst.insert(root, 7);
        bst.inorder(root); // Output: 3 5 7
    }
}
