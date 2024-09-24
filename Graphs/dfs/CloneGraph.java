package Graphs.dfs;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    public static Node cloneHelper(Node root, Map<Node, Node> nodesCompleted) {
        if (root == null) {
            return null;
        }

        Node clonedNode = new Node(root.data);

        nodesCompleted.put(root, clonedNode);

        for (Node p : root.neighbors) {
            Node x = nodesCompleted.get(p);
            if (x == null) {
                clonedNode.neighbors.add(cloneHelper(p, nodesCompleted));
            }
            else {
                clonedNode.neighbors.add(x);
            }
        }
        return clonedNode;
    }

    public static Node clone(Node root) {
        Map<Node, Node> nodesCompleted = new HashMap<Node, Node>();
        return cloneHelper(root, nodesCompleted);
    }

    // Driver code
    public static void main(String[] args) {
        int[][][] data = {
                {{2, 3}, {1, 3}, {1, 2}},
                {{2, 4}, {1, 3}, {2, 4}, {1, 3}},
                {{2, 5}, {1, 3}, {2, 4}, {3, 5}, {1, 4}},
                {{2}, {1}},
                {{2, 6}, {1, 3}, {2, 4}, {3, 5}, {4, 6}, {1, 5}},
                {{}}
        };

        for (int i = 0; i < data.length; i++) {
            Node node1 = GraphUtility.createGraph(data[i]);
            System.out.println((i + 1) + ".\t Original Graph: " + GraphUtility.create2DList(node1) + "\n");
            GraphUtility.printGraph(node1);
            System.out.println();
            Node clonedRoot = clone(node1);
            System.out.println("\t Cloned Graph: " + GraphUtility.create2DList(clonedRoot) + "\n");
            GraphUtility.printGraph(node1);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
