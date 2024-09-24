package Graphs.dfs;

import java.util.ArrayList;
import java.util.List;

public class DetectCycle {

    private void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int dest) {
        adj.get(source).add(dest);
    }

    private static boolean isCyclic(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];


        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack,adj))
                return true;

        return false;
    }

    private static boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack,ArrayList<ArrayList<Integer>> adj)
    {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c: children)
            if (isCyclicUtil(c, visited, recStack,adj))
                return true;

        recStack[i] = false;

        return false;
    }


    public static void main(String[] args)
    {
        DetectCycle graph = new DetectCycle();
        int V=4;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(V);

        for (int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        graph.addEdge(adj,0, 1);
       // graph.addEdge(adj,0, 2);
       // graph.addEdge(adj,1, 2);
        graph.addEdge(adj,2, 0);
        graph.addEdge(adj,2, 3);
        graph.addEdge(adj,3, 3);

        if(isCyclic(V,adj))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
