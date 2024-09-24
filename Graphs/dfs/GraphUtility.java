package Graphs.dfs;

import java.util.*;

public class GraphUtility{
    public static Node createGraph(int[][] data) {
        if(data.length == 0){
            return new Node(1);
        }
        Node[] nodes = new Node[data.length];
        for (int i = 0; i < data.length; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < data.length; i++) {
            for (int neighbor : data[i]) {
                nodes[i].neighbors.add(nodes[neighbor - 1]);
            }
        }
        return nodes[0];
    }

    public static List<List<Integer>> create2DList(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        HashMap<Node, Node> visited = new HashMap<Node, Node>();
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        HashMap<Node, Integer> nodeIndex = new HashMap<Node, Integer>();
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            List<Integer> neighbors = new ArrayList<Integer>();
            for (Node neighbor : node.neighbors) {
                neighbors.add(visited.getOrDefault(neighbor, neighbor).data);
                if (!visited.containsKey(neighbor) && !queue.contains(neighbor)) {
                    visited.put(neighbor, neighbor);
                    queue.add(neighbor);
                }
            }
            Collections.sort(neighbors);
            if (!nodeIndex.containsKey(node)) {
                int index = graph.size();
                nodeIndex.put(node, index);
                List<Integer> sublist = new ArrayList<Integer>();
                sublist.add(node.data);
                sublist.addAll(neighbors);
                graph.add(sublist);
            }
        }
        Collections.sort(graph, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b) {
                return a.get(0) - b.get(0);
            }
        });
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> sublist : graph) {
            List<Integer> sub = new ArrayList<>(sublist.subList(1, sublist.size()));
            result.add(sub);
        }
        return result;
    }

    public static void printGraphRec(Node root, Set<Node> visitedNodes) {
        if (root == null || visitedNodes.contains(root)) {
            return;
        }

        visitedNodes.add(root);
        System.out.print("\t" + root.data + ": {");
        for (Node n : root.neighbors) {
            System.out.print(n.data + " ");
        }
        System.out.println("}");

        for (Node n : root.neighbors) {
            printGraphRec(n, visitedNodes);
        }
    }

    public static void printGraph(Node root) {
        Set<Node> visitedNodes = new HashSet<>();
        printGraphRec(root, visitedNodes);
    }
}