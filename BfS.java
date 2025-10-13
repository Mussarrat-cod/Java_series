import java.util.*;

public class BFS {
    private int vertices; // number of vertices
    private LinkedList<Integer> adj[]; // adjacency list

    // constructor
    BFS(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    // add an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS traversal from a given source
    void bfs(int start) {
        boolean visited[] = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int n : adj[node]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // main method
    public static void main(String[] args) {
        BFS graph = new BFS(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        System.out.println("BFS starting from node 0:");
        graph.bfs(0);
    }
}
