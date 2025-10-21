import java.util.*;

class AOStar {

    static class Node {
        String name;
        boolean isSolved = false;
        boolean isAndNode = false;
        List<List<Node>> children = new ArrayList<>(); // Each list represents a group (AND or OR)
        Node parent = null;

        Node(String name) {
            this.name = name;
        }

        void addOrChildren(Node... nodes) {
            children.add(Arrays.asList(nodes));
        }

        void addAndChildren(Node... nodes) {
            List<Node> andGroup = Arrays.asList(nodes);
            for (Node child : andGroup) {
                child.isAndNode = true;
                child.parent = this;
            }
            children.add(andGroup);
        }
    }

    static Set<Node> solved = new HashSet<>();
    static Map<Node, Integer> costMap = new HashMap<>();

    static int aoStar(Node node) {
        if (node.isSolved) return 0;

        int minCost = Integer.MAX_VALUE;
        List<Node> bestGroup = null;

        for (List<Node> group : node.children) {
            int groupCost = 0;
            for (Node child : group) {
                groupCost += aoStar(child) + 1; // assume unit cost
            }

            if (groupCost < minCost) {
                minCost = groupCost;
                bestGroup = group;
            }
        }

        if (bestGroup != null) {
            node.isSolved = true;
            for (Node child : bestGroup) {
                child.parent = node;
            }
            solved.add(node);
            costMap.put(node, minCost);
        }

        return minCost;
    }

    static void printSolution(Node node) {
        if (node == null || !node.isSolved) return;

        System.out.print(node.name);
        for (List<Node> group : node.children) {
            boolean allSolved = true;
            for (Node child : group) {
                if (!solved.contains(child)) {
                    allSolved = false;
                    break;
                }
            }

            if (allSolved) {
                System.out.print(" -> (");
                for (Node child : group) {
                    printSolution(child);
                    System.out.print(" ");
                }
                System.out.print(")");
                break;
            }
        }
    }

    public static void main(String[] args) {
        // Constructing an example AND-OR graph

        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");

        A.addOrChildren(B, C);      // A → B or C
        B.addAndChildren(D, E);     // B → D AND E
        C.addOrChildren(F);         // C → F

        // Assume leaf nodes are solved
        D.isSolved = true;
        E.isSolved = true;
        F.isSolved = true;

        // Run AO* algorithm
        aoStar(A);

        System.out.println("Optimal solution path:");
        printSolution(A);
    }
}
