package utils.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Graph {
    
    Map<Node, List<Node>> adjacent = new HashMap<>();

    public class Node{
        int val;
        Node left, right;
        Node(int val, Node left, Node right){
         this.val = val;
         this.left=left;
         this.right=right;
        }
    }
    
    private Node getNode(int val) {
        if()
        return null;
    }
    public void addToGraph(int source, int dest) {
        Node sourceNode = getNode(source);
        
    }
}
