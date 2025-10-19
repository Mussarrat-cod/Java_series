import java.util.*;

class AStar {

    static class Node {
        int x, y;
        int gCost, hCost;
        Node parent;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int fCost() {
            return gCost + hCost;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node)) return false;
            Node other = (Node) obj;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static final int[][] DIRECTIONS = {
        {0, -1}, {0, 1}, {-1, 0}, {1, 0} // Up, Down, Left, Right
    };

    public static List<Node> aStarSearch(int[][] grid, int startX, int startY, int endX, int endY) {
        Node start = new Node(startX, startY);
        Node end = new Node(endX, endY);

        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(Node::fCost));
        Set<Node> closedSet = new HashSet<>();

        start.gCost = 0;
        start.hCost = heuristic(start, end);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.equals(end)) {
                return reconstructPath(current);
            }

            closedSet.add(current);

            for (int[] dir : DIRECTIONS) {
                int nx = current.x + dir[0];
                int ny = current.y + dir[1];

                if (!isWalkable(grid, nx, ny)) continue;

                Node neighbor = new Node(nx, ny);
                if (closedSet.contains(neighbor)) continue;

                int tentativeG = current.gCost + 1;

                boolean inOpenSet = openSet.contains(neighbor);
                if (!inOpenSet || tentativeG < neighbor.gCost) {
                    neighbor.gCost = tentativeG;
                    neighbor.hCost = heuristic(neighbor, end);
                    neighbor.parent = current;

                    if (!inOpenSet) {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        return Collections.emptyList(); // No path found
    }

    private static int heuristic(Node a, Node b) {
        // Manhattan distance
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private static boolean isWalkable(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0;
    }

    private static List<Node> reconstructPath(Node end) {
        List<Node> path = new ArrayList<>();
        Node current = end;
        while (current != null) {
            path.add(current);
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }

    // --- Example Usage ---
    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 0}
        };

        List<Node> path = aStarSearch(grid, 0, 0, 4, 4);

        if (!path.isEmpty()) {
            System.out.println("Path found:");
            for (Node node : path) {
                System.out.println("(" + node.x + ", " + node.y + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }
}
