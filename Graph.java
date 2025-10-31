    import java.util.*;
    class Graph {
        private int V;
        private LinkedList<Integer> adj[];
        Graph(int v) { V = v; adj = new LinkedList[v]; for (int i=0; i<v; ++i) adj[i] = new LinkedList(); }
        void addEdge(int v, int w) { adj[v].add(w); }
        void BFS(int s) {
            boolean visited[] = new boolean[V];
            LinkedList<Integer> queue = new LinkedList<>();
            visited[s] = true; queue.add(s);
            while (!queue.isEmpty()) {
                s = queue.poll(); System.out.print(s + " ");
                for (Integer n : adj[s]) {
                    if (!visited[n]) { visited[n] = true; queue.add(n); }
                }
            }
        }
    }
    
