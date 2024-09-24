package Graphs.dfs;

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    List<Node> neighbors;

    public Node(int data) {
        this.data = data;
        this.neighbors = new ArrayList<Node>();
    }
}